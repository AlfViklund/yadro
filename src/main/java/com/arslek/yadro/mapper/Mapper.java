package com.arslek.yadro.mapper;

import java.util.List;

public interface Mapper<DTO, ENTITY> {

    ENTITY destinationToSource(DTO dto);
    List<ENTITY> destinationToSource(List<DTO> dto);

    DTO sourceToDestination(ENTITY entity);
    List<DTO> sourceToDestination(List<ENTITY> entity);
}
