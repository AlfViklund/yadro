package com.arslek.yadro.service;

import com.arslek.yadro.dto.PairingDto;
import com.arslek.yadro.dto.UniRequestDto;
import com.arslek.yadro.entity.PairingEntity;
import com.arslek.yadro.mapper.PairingMapper;
import com.arslek.yadro.repository.PairingRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PairingService extends AbstractCrudService<Long, PairingDto, PairingEntity, PairingRepository, PairingMapper> {
    protected PairingService(PairingRepository repository) {
        super(repository, Mappers.getMapper(PairingMapper.class));
    }

    @Transactional
    public List<PairingDto> createAll(UniRequestDto uniDto) {
        return super.createAll(uniDto.getPairings());
    }
}
