create schema if not exists yadro;

CREATE TABLE IF NOT EXISTS yadro.employee
(
    id     BIGINT NOT NULL
        CONSTRAINT pk_employee
            PRIMARY KEY,
    gender VARCHAR(255),
    fleet  VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS yadro.pairing
(
    id              BIGINT NOT NULL
        CONSTRAINT pk_pairing
            PRIMARY KEY,
    fleet           VARCHAR(255),
    date_time_start TIMESTAMP,
    date_time_end   TIMESTAMP
);

CREATE TABLE IF NOT EXISTS yadro.flight
(
    id                  BIGINT NOT NULL
        CONSTRAINT pk_flight
            PRIMARY KEY,
    flight_num          VARCHAR(255),
    station_departure   VARCHAR(255),
    station_arrival     VARCHAR(255),
    date_time_departure TIMESTAMP,
    date_time_arrival   TIMESTAMP
);

CREATE TABLE IF NOT EXISTS yadro.assignment
(
    id          BIGINT NOT NULL
        CONSTRAINT pk_assignment
            PRIMARY KEY,
    employee_id BIGINT REFERENCES yadro.employee,
    pairing_id  BIGINT REFERENCES yadro.pairing,
    rank        VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS yadro.pairing_flights
(
    pairing_id  BIGINT REFERENCES yadro.pairing,
    flight_id  BIGINT REFERENCES yadro.flight
);

create sequence if not exists yadro.employee_id_seq
    increment by 1
    owned by employee.id;

create sequence if not exists yadro.flight_id_seq
    increment by 1
    owned by flight.id;

create sequence if not exists yadro.pairing_id_seq
    increment by 1
    owned by pairing.id;

create sequence if not exists yadro.assignment_id_seq
    increment by 1
    owned by assignment.id;