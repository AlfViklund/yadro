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

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PairingDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("Fleet")
    private String fleet;

    @JsonProperty("DateTimeStart")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm z")
    private Date dateTimeStart;

    @JsonProperty("DateTimeEnd")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm z")
    private Date dateTimeEnd;

    @JsonProperty("Duties")
    private List<DutyDto> duties;
}
