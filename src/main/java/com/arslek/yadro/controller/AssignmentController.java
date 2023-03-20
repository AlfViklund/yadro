package com.arslek.yadro.controller;

import com.arslek.yadro.dto.AssignmentDto;
import com.arslek.yadro.dto.EmployeeDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.service.AssignmentService;
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
public class AssignmentController {

    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @PostMapping("assignment")
    public AssignmentDto upsert(@RequestBody AssignmentDto dto) {
        return service.create(dto);
    }

    @PostMapping("assignments")
    public List<AssignmentDto> upsert(@RequestBody UniRequestDto uniRequestDto) {
        return service.createAll(uniRequestDto);
    }

    @GetMapping("assignment/{id}")
    public AssignmentDto read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("assignment/{id}")
    public AssignmentDto update(@PathVariable Long id, @RequestBody AssignmentDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("assignment/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
