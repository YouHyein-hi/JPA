package com.example.labprojectjpa.analyze;

import lombok.RequiredArgsConstructor;
import net.sf.javainetlocator.InetAddressLocator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "list";
    }

    /*게시판 상세페이지*/
    @GetMapping("/list-test/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        AnalyzeDTO analyzeDTO = analyzeService.getPost(id);
        model.addAttribute("analyzeDTO", analyzeDTO);
        return "detail";
    }

    @GetMapping("/analyze/{pictureName}")
    public ResponseEntity<Analyze> getAnalyze(@PathVariable String pictureName){
        Analyze analyze = analyzeService.getAnalyze(pictureName);
        return new ResponseEntity<>(analyze,HttpStatus.OK);
    }
}