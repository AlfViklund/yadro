package com.arslek.yadro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "yadro", name = "assignment")
public class AssignmentEntity extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="assignment_id_seq")
    @SequenceGenerator(name="assignment_id_seq", sequenceName="assignment_id_seq", allocationSize=1)
    private Long id;

    @Column(name="employee_id")
    private Long employeeId;

    @Column(name="pairing_id")
    private Long pairingId;

    @Column(name="rank")
    private String rank;
}
