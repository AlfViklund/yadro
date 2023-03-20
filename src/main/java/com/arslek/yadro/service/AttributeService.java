package com.arslek.yadro.service;

import com.arslek.yadro.dto.FlightDto;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Service
public class AttributeService {

    public Map<String, String> getAttributes() {
        FlightDto dto = new FlightDto();
        return dto.getAttributes();
    }
}
