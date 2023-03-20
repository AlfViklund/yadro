package com.arslek.yadro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniRequestDto {

    @JsonProperty("Flights")
    List<FlightDto> flights;

    @JsonProperty("Pairings")
    List<PairingDto> pairings;

    @JsonProperty("Assignments")
    List<AssignmentDto> assignments;

    @JsonProperty("Employees")
    List<EmployeeDto> employees;
}
