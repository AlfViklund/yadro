package com.arslek.yadro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "yadro", name = "flight")
public class FlightEntity extends AbstractEntity<Long> {

    @Id
    private Long id;

    @Column(name="flight_num")
    private String flightNum;

    @Column(name="station_departure")
    private String stationDeparture;

    @Column(name="station_arrival")
    private String stationArrival;

    @Column(name="date_time_departure")
    private Date dateTimeDeparture;

    @Column(name="date_time_arrival")
    private Date dateTimeArrival;
}
