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

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "yadro", name = "employee")
public class EmployeeEntity extends AbstractEntity<Long> {

    @Id
    private Long id;

    @Column(name="gender")
    private String gender;

    @Column(name="fleet")
    private String fleet;
}
