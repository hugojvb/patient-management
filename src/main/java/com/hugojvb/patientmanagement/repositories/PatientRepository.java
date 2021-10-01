package com.hugojvb.patientmanagement.repositories;

import java.util.List;

import com.hugojvb.patientmanagement.models.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findAllByUserId(Long id);
}
