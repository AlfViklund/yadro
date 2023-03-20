package com.arslek.yadro.controller;

import com.arslek.yadro.dto.FlightDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.service.FlightService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("crud")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping("flight")
    public FlightDto upsert(@RequestBody FlightDto dto) {
        return service.create(dto);
    }

    @PostMapping("flights")
    public List<FlightDto> upsert(@RequestBody UniRequestDto uniRequestDto) {
        return service.createAll(uniRequestDto);
    }

    @GetMapping("flight/{id}")
    public FlightDto read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("flight/{id}")
    public FlightDto update(@PathVariable Long id, @RequestBody FlightDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("flight/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
