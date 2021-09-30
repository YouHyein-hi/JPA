package com.example.labprojectjpa.analyze;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyzeService {

    private final AnalyzeRepository analyzeRepository;

    public List<Analyze> getAnalyzeList() {
        return analyzeRepository.findAll();
    }

    public Analyze addAnalyze(AnalyzeDTO AnalyzeDto) {
        Analyze analyze = Analyze.builder()
                .pictureDate(AnalyzeDto.getPictureDate())
                .pictureName(AnalyzeDto.getPictureName())
                .analyzeResult(AnalyzeDto.getAnalyzeResult())
                .analyzePercent(AnalyzeDto.getAnalyzePercent())
                .requestIp(AnalyzeDto.getRequestIp())
                .build();
        analyzeRepository.save(analyze);
        return analyze;
    }

    public Analyze getAnalyze(String picName) {
        Analyze analyze = analyzeRepository.findBypictureName(picName).orElseThrow(() -> new RuntimeException("DB 조회 결과가 없습니다."));
        return analyze;
    }

    /*게시판 관련
    https://velog.io/@max9106/Spring-Boot-JPA-MySQL-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EC%A1%B0%ED%9A%8C
    @Transactional
    public static List<AnalyzeDTO> getAnalyzelistDTO() {
        List<Analyze> analyzes = analyzeRepository.findAll();
        List<AnalyzeDTO> analyzeDtoList = new ArrayList<>();

        for ( Analyze analyze : analyzes) {
            AnalyzeDTO analyzeDTO = AnalyzeDTO.builder()
                    .pictureDate(analyze.getPictureDate())
                    .pictureName(analyze.getPictureName())
                    .analyzeResult(analyze.getAnalyzeResult())
                    .analyzePercent(analyze.getAnalyzePercent())
                    .requestIp(analyze.getRequestIp())
                    .build();

            analyzeDtoList.add(analyzeDTO);
        }
        return analyzeDtoList;
    }*/
}