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
                .userIp(AnalyzeDto.getRequestIp())
                .build();
        analyzeRepository.save(analyze);
        return analyze;
    }

    public Analyze getAnalyze(String picName) {
        Analyze analyze = analyzeRepository.findBypictureName(picName).orElseThrow(() -> new RuntimeException("DB 조회 결과가 없습니다."));
        return analyze;
    }
}