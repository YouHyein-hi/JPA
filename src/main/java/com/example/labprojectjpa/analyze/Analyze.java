package com.example.labprojectjpa.analyze;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
/*@AllArgsConstructor*/
@Builder
public class Analyze {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String pictureDate;

    @Column
    private String pictureName;

    @Column
    private String analyzeResult;

    @Column
    private Integer analyzePercent;

    @Column
    private String requestIp;

    @Builder
    public Analyze(Long id, String pictureDate, String pictureName, String analyzeResult, Integer analyzePercent, String requestIp){
        this.id = id;
        this.pictureDate = pictureDate;
        this.pictureName = pictureName;
        this.analyzeResult = analyzeResult;
        this.analyzePercent = analyzePercent;
        this.requestIp = requestIp;
    }
}