package com.example.labprojectjpa.analyze;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
                .localeIpCountry(AnalyzeDto.getLocaleIpCountry())
                .build();
        analyzeRepository.save(analyze);
        return analyze;
    }

    public Analyze getAnalyze(String picName) {
        Analyze analyze = analyzeRepository.findBypictureName(picName).orElseThrow(() -> new RuntimeException("DB 조회 결과가 없습니다."));
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

    /*ip 국가해서 가져오기*/
    public Analyze getLocaleIp(AnalyzeDTO analyzeDTO, String requestIp) {
        Locale locale = new Locale(requestIp);
        String localIpCountry = locale.getCountry();

        Analyze analyze = Analyze.builder()
                .pictureName(analyzeDTO.getPictureName())
                .pictureDate(analyzeDTO.getPictureDate())
                .analyzeResult(analyzeDTO.getAnalyzeResult())
                .analyzePercent(analyzeDTO.getAnalyzePercent())
                .requestIp(analyzeDTO.getRequestIp())
                .localeIpCountry(localIpCountry)
                /*.localeIpCountry(getlocalIpCountry())*/
                /*.localeIpCountry(locale.getCountry())*/
                .build();

        analyzeRepository.save(analyze);
        return analyze;
    }
}