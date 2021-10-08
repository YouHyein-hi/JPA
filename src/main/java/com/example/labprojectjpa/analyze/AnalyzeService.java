package com.example.labprojectjpa.analyze;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
                .countryIp(new Locale(AnalyzeDto.getRequestIp()).getCountry())
                .build();
        analyzeRepository.save(analyze);
        return analyze;
    }

    public Analyze getAnalyze(String pictureName) {
        Analyze analyze = analyzeRepository.findBypictureName(pictureName).orElseThrow(() -> new RuntimeException("DB 조회 결과가 없습니다."));
        return analyze;
    }

    /*게시판*/
    @Transactional
    public List<AnalyzeDTO> getAnalyzelistDTO() {
        List<Analyze> analyzes = analyzeRepository.findAll();
        List<AnalyzeDTO> analyzeDTOList = new ArrayList<>();

        for(Analyze analyze : analyzes) {
            AnalyzeDTO analyzeDTO = AnalyzeDTO.builder()
                    .id(analyze.getId())
                    .pictureDate(analyze.getPictureDate())
                    .pictureName(analyze.getPictureName())
                    .analyzeResult(analyze.getAnalyzeResult())
                    .analyzePercent(analyze.getAnalyzePercent())
                    .requestIp(analyze.getRequestIp())
                    .build();
            analyzeDTOList.add(analyzeDTO);
        }
        return analyzeDTOList;
    }

    /*게시판 상세페이지*/
    @Transactional
    public AnalyzeDTO getPost(Long id) {
        Optional<Analyze> analyzeWrapper = analyzeRepository.findById(id);
        Analyze analyze = analyzeWrapper.get();

        AnalyzeDTO analyzeDTO = AnalyzeDTO.builder()
                .id(analyze.getId())
                .pictureDate(analyze.getPictureDate())
                .pictureName(analyze.getPictureName())
                .analyzeResult(analyze.getAnalyzeResult())
                .analyzePercent(analyze.getAnalyzePercent())
                .requestIp(analyze.getRequestIp())
                .build();

        return analyzeDTO;
    }
}