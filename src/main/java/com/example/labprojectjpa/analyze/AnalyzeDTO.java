package com.example.labprojectjpa.analyze;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalyzeDTO {
    private String pictureDate;
    private String pictureName;
    private String analyzeResult;
    private Integer analyzePercent;
    private String requestIp;
}
