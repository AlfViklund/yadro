package com.arslek.yadro.mapper;

import com.arslek.yadro.dto.AssignmentDto;
import com.arslek.yadro.entity.AssignmentEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface AssignmentMapper extends Mapper<AssignmentDto, AssignmentEntity> {
}
