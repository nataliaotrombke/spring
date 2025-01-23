package com.github.nataliaotrombke.demoapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogsController {

    private static final String LOG_FILE_PATH = "/Users/nataliaotrombke/IdeaProjects/nowyprojekt/Demo/demo-api/logs/application.log";


    //required-wymagany
    @GetMapping
    public ResponseEntity<?> getFilteredLogs(
            @RequestParam(required = false) String level,    // Poziom logów (INFO, ERROR, WARN)
            @RequestParam(required = false) Integer limit,  // Ograniczenie liczby wierszy
            @RequestParam(required = false) String keyword,  // Filtrowanie po słowie kluczowym
            @RequestParam(required = false) Integer skip // Omijanie liczby wierszy
    ) {
        try {
            Path path = Paths.get(LOG_FILE_PATH);
            if (!Files.exists(path)) {
                return ResponseEntity.notFound().build();
            }

            List<String> lines = Files.readAllLines(path);

            // Filtrowanie po poziomie logu
            if (level != null) {
                lines = lines
                        .stream()
                        .filter(line -> line.contains(level.toUpperCase()))
                        .toList();
            }

            // Filtrowanie po słowie kluczowym
            if (keyword != null) {
                lines = lines
                        .stream()
                        .filter(line -> line.contains(keyword))
                        .toList();
            }

            //Omijanie liczby wierszy
            if (skip != null && skip > 0) {
                lines = lines
                        .stream()
                        .skip(skip)
                        .toList();
            }

            // Ograniczenie liczby wierszy
            if (limit != null && limit > 0) {
                lines = lines
                        .stream()
                        .limit(limit)
                        .toList();
            }

            return ResponseEntity.ok(String.join("\n", lines));
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Error reading log file: " + e.getMessage());
        }
    }
}