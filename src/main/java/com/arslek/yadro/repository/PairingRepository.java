package com.arslek.yadro.repository;

import com.arslek.yadro.entity.PairingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairingRepository extends JpaRepository<PairingEntity, Long> {

    @Query(value = "select p.* from yadro.pairing p inner join yadro.assignment a on p.id = a.pairing_id where employee_id = :id",
            nativeQuery = true)
    List<PairingEntity> getPairingsById(Long id);
}
