package com.arslek.yadro.service;

import com.arslek.yadro.dto.AssignmentDto;
import com.arslek.yadro.dto.EmployeeDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.entity.AssignmentEntity;
import com.arslek.yadro.mapper.AssignmentMapper;
import com.arslek.yadro.repository.AssignmentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentService extends AbstractCrudService<Long, AssignmentDto, AssignmentEntity, AssignmentRepository, AssignmentMapper> {
    protected AssignmentService(AssignmentRepository repository) {
        super(repository, Mappers.getMapper(AssignmentMapper.class));
    }

    @Transactional
    public List<AssignmentDto> createAll(UniRequestDto uniDto) {
        return super.createAll(uniDto.getAssignments());
    }
}
