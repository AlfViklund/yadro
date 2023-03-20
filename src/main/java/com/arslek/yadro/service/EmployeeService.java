package com.arslek.yadro.service;

import com.arslek.yadro.dto.EmployeeDto;
import com.arslek.yadro.dto.FlightDto;
import com.arslek.yadro.dto.PairingDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.entity.EmployeeEntity;
import com.arslek.yadro.entity.FlightEntity;
import com.arslek.yadro.entity.PairingEntity;
import com.arslek.yadro.mapper.EmployeeMapper;
import com.arslek.yadro.mapper.FlightMapper;
import com.arslek.yadro.mapper.PairingMapper;
import com.arslek.yadro.repository.EmployeeRepository;
import com.arslek.yadro.repository.FlightRepository;
import com.arslek.yadro.repository.PairingRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService extends AbstractCrudService<Long, EmployeeDto, EmployeeEntity, EmployeeRepository, EmployeeMapper> {
    private final PairingMapper pairingMapper;
    private final FlightMapper flightMapper;

    private final FlightRepository flightRepository;

    private final PairingRepository pairingRepository;

    protected EmployeeService(EmployeeRepository repository, FlightRepository flightRepository, PairingRepository pairingRepository) {
        super(repository, Mappers.getMapper(EmployeeMapper.class));
        this.flightRepository = flightRepository;
        this.pairingRepository = pairingRepository;
        pairingMapper = Mappers.getMapper(PairingMapper.class);
        flightMapper = Mappers.getMapper(FlightMapper.class);
    }

    @Transactional
    public List<PairingDto> getPairingsById(Long id) {
        List<PairingEntity> entities = pairingRepository.getPairingsById(id);
        return pairingMapper.sourceToDestination(entities);
    }

    @Transactional
    public List<FlightDto> getFlightsById(Long id) {
        List<FlightEntity> entities = flightRepository.getFlightsById(id);
        return flightMapper.sourceToDestination(entities);
    }

    @Transactional
    public List<EmployeeDto> createAll(UniRequestDto uniDto) {
        return super.createAll(uniDto.getEmployees());
    }
}
