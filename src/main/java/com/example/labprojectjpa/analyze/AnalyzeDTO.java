package com.example.labprojectjpa.analyze;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalyzeDTO {
    private Long id;
    private String pictureDate;
    private String pictureName;
    private String analyzeResult;
    private Integer analyzePercent;
    private String requestIp;

}


    /*public Analyze toEntity() {
        Analyze build = Analyze.builder()
                .pictureDate(pictureDate)
                .pictureName(pictureName)
                .analyzeResult(analyzeResult)
                .analyzePercent(analyzePercent)
                .requestIp(requestIp)
                .build();
        return build;
    }*/

    /*@Builder
    public void AnalyzeDto(String pictureDate, String pictureName, String analyzeResult, Integer analyzePercent, String requestIp) {
        this.pictureDate = pictureDate;
        this.pictureName = pictureName;
        this.analyzeResult = analyzeResult;
        this.analyzePercent = analyzePercent;
        this.requestIp = requestIp;
    }*/