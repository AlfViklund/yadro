package com.arslek.yadro.controller;

import com.arslek.yadro.dto.EmployeeDto;
import com.arslek.yadro.dto.FlightDto;
import com.arslek.yadro.dto.PairingDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.service.EmployeeService;
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
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("employee")
    public EmployeeDto upsert(@RequestBody EmployeeDto dto) {
        return service.create(dto);
    }

    @GetMapping("employee/pairing/{id}")
    public List<PairingDto> getPairingsByEmployeeId(@PathVariable Long id) {
        return service.getPairingsById(id);
    }

    @GetMapping("employee/flight/{id}")
    public List<FlightDto> getFlightsByEmployeeId(@PathVariable Long id) {
        return service.getFlightsById(id);
    }

    @PostMapping("employees")
    public List<EmployeeDto> upsert(@RequestBody UniRequestDto uniRequestDto) {
        return service.createAll(uniRequestDto);
    }

    @GetMapping("employee/{id}")
    public EmployeeDto read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("employee/{id}")
    public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("employee/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
