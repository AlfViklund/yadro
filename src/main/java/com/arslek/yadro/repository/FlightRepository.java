package com.arslek.yadro.repository;

import com.arslek.yadro.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    @Query(value = "SELECT f.* FROM yadro.flight f INNER JOIN yadro.pairing_flights pf ON f.id = pf.flight_id INNER JOIN yadro.pairing p ON p.id = pf.pairing_id INNER JOIN yadro.assignment a ON p.id = a.pairing_id WHERE a.employee_id = :id",
            nativeQuery = true)
    List<FlightEntity> getFlightsById(Long id);
}
