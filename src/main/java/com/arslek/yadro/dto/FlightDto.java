package com.arslek.yadro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("FlightNum")
    private String flightNum;

    @JsonProperty("StationDeparture")
    private String stationDeparture;

    @JsonProperty("StationArrival")
    private String stationArrival;

    @JsonProperty("DateTimeDeparture")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm z")
    private Date dateTimeDeparture;

    @JsonProperty("DateTimeArrival")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm z")
    private Date dateTimeArrival;

    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new HashMap<>();
        for (Field f : FlightDto.class.getDeclaredFields()) {
            attributes.put(f.getName(), String.valueOf(f.getType()));
        }
        return attributes;
    }
}
