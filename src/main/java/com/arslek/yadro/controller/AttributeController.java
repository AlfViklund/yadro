package com.arslek.yadro.controller;

import com.arslek.yadro.dto.AssignmentDto;
import com.arslek.yadro.service.AssignmentService;
import com.arslek.yadro.service.AttributeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AttributeController {

    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping("attributes")
    public Map<String, String> getAttributes() {
        return attributeService.getAttributes();
    }
}
