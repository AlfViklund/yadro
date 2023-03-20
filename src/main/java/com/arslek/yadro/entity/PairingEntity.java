package com.arslek.yadro.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "yadro", name = "pairing")
public class PairingEntity extends AbstractEntity<Long> {

    @Id
    private Long id;

    @Column(name="fleet")
    private String fleet;

    @Column(name="date_time_start")
    private Date dateTimeStart;

    @Column(name="date_time_end")
    private Date dateTimeEnd;

    @ElementCollection
    @CollectionTable(
            schema = "yadro",
            name = "pairing_flights",
            joinColumns = @JoinColumn(name = "pairing_id")
    )
    @Column(name = "flight_id")
    private List<Long> flights;
}
