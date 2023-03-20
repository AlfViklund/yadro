package com.arslek.yadro.service;

import com.arslek.yadro.dto.FlightDto;
import com.arslek.yadro.dto.PairingDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.entity.FlightEntity;
import com.arslek.yadro.mapper.FlightMapper;
import com.arslek.yadro.repository.FlightRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.InputMismatchException;
import java.util.List;

@Service
public class FlightService extends AbstractCrudService<Long, FlightDto, FlightEntity, FlightRepository, FlightMapper> {
    protected FlightService(FlightRepository repository) {
        super(repository, Mappers.getMapper(FlightMapper.class));
    }

    @Transactional
    public List<FlightDto> createAll(UniRequestDto uniDto) {
        return super.createAll(uniDto.getFlights());
    }
}
