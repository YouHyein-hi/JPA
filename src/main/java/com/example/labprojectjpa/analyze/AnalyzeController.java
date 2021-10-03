package com.example.labprojectjpa.analyze;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnalyzeController {

    private final AnalyzeService analyzeService;

    @GetMapping("/")
    public ResponseEntity<List<Analyze>> getAllAnalyze(){
        List<Analyze> list = analyzeService.getAnalyzeList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/analyze")
    public ResponseEntity<Analyze> addAnalyze(AnalyzeDTO analyzeDto) {
        Analyze analyze = analyzeService.addAnalyze(analyzeDto);
        return new ResponseEntity<>(analyze, HttpStatus.CREATED);
    }

    /*게시판*/
    @GetMapping("/list-test")
    public String list(Model model) {
        List<AnalyzeDTO> analyzeDTOList = analyzeService.getAnalyzelistDTO();
        model.addAttribute("analyzeList", analyzeDTOList);
        return "list.html";
    }

    @GetMapping("/analyze/{pictureName}")
    public ResponseEntity<Analyze> getAnalyze(@PathVariable String pictureName){
        Analyze analyze = analyzeService.getAnalyze(pictureName);
        return new ResponseEntity<>(analyze,HttpStatus.OK);
    }
}