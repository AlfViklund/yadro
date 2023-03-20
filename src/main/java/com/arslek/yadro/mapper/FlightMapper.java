package com.arslek.yadro.mapper;

import com.arslek.yadro.dto.FlightDto;
import com.arslek.yadro.entity.FlightEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface FlightMapper extends Mapper<FlightDto, FlightEntity> {
}
