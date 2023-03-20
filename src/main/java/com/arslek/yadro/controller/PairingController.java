package com.arslek.yadro.controller;

import com.arslek.yadro.dto.PairingDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.service.PairingService;
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
public class PairingController {

    private final PairingService service;

    public PairingController(PairingService service) {
        this.service = service;
    }

    @PostMapping("pairing")
    public PairingDto upsert(@RequestBody PairingDto dto) {
        return service.create(dto);
    }

    @PostMapping("pairings")
    public List<PairingDto> upsert(@RequestBody UniRequestDto uniRequestDto) {
        return service.createAll(uniRequestDto);
    }

    @GetMapping("pairing/{id}")
    public PairingDto read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("pairing/{id}")
    public PairingDto update(@PathVariable Long id, @RequestBody PairingDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("pairing/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
