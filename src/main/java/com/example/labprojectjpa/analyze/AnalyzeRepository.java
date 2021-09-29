package com.example.labprojectjpa.analyze;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalyzeRepository extends JpaRepository<Analyze, Long> {
    Optional<Analyze> findBypictureName(String pictureName);
}