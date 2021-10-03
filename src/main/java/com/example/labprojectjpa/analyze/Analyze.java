package com.example.labprojectjpa.analyze;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Analyze {

    @Id
    // 키 생성 전략에 대한 것 공부
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

/*
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Analyze {

    @Id
    // 키 생성 전략에 대한 것 공부
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
