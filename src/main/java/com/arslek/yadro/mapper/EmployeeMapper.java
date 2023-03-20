package com.arslek.yadro.mapper;

import com.arslek.yadro.dto.EmployeeDto;
import com.arslek.yadro.entity.EmployeeEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface EmployeeMapper extends Mapper<EmployeeDto, EmployeeEntity> {
}
