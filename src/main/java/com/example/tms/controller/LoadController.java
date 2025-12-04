package com.example.tms.controller;

import com.example.tms.dto.LoadDto;
import com.example.tms.entity.Load;
import com.example.tms.service.LoadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loads")
public class LoadController {

    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @PostMapping
    public Load createLoad(@RequestBody LoadDto loadDto) {
        return loadService.createLoad(loadDto);
    }

    @GetMapping
    public List<Load> getAllLoads() {
        return loadService.getAllLoads();
    }

    @GetMapping("/{id}")
    public Load getLoadById(@PathVariable UUID id) {
        return loadService.getLoadById(id);
    }

    @PutMapping("/{id}")
    public Load updateLoad(@PathVariable UUID id, @RequestBody LoadDto loadDto) {
        return loadService.updateLoad(id, loadDto);
    }

    @DeleteMapping("/{id}")
    public void deleteLoad(@PathVariable UUID id) {
        loadService.deleteLoad(id);
    }
}
