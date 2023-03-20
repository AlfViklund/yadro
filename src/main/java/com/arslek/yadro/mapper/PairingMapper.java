package com.arslek.yadro.mapper;

import com.arslek.yadro.dto.LegDto;
import com.arslek.yadro.dto.PairingDto;
import com.arslek.yadro.entity.PairingEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@org.mapstruct.Mapper(componentModel = "spring")
public interface PairingMapper extends Mapper<PairingDto, PairingEntity> {

    @Override
    default PairingEntity destinationToSource(PairingDto pairingDto) {
        PairingEntity entity = PairingEntity.builder()
                .id(pairingDto.getId())
                .fleet(pairingDto.getFleet())
                .dateTimeStart(pairingDto.getDateTimeStart())
                .dateTimeEnd(pairingDto.getDateTimeEnd())
                .build();
        if (!CollectionUtils.isEmpty(pairingDto.getDuties())) {
            entity.setFlights(pairingDto.getDuties()
                    .stream()
                    .flatMap(d -> {
                        if (!CollectionUtils.isEmpty(d.getLegs())) {
                            return d.getLegs()
                                    .stream()
                                    .map(LegDto::getFlightId);
                        } else {
                            return null;
                        }
                    })
                    .collect(Collectors.toList()));
        }
        return entity;
    }

    @Override
    default PairingDto sourceToDestination(PairingEntity pairingEntity) {
        return PairingDto.builder()
                .id(pairingEntity.getId())
                .fleet(pairingEntity.getFleet())
                .dateTimeStart(pairingEntity.getDateTimeStart())
                .dateTimeEnd(pairingEntity.getDateTimeEnd())
                .build();
    }
}
