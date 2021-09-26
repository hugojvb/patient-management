package com.hugojvb.patientmanagement.repositories;

import com.hugojvb.patientmanagement.models.Observation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Long> {

}
