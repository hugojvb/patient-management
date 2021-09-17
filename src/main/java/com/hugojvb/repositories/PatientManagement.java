package com.hugojvb.repositories;

import com.hugojvb.models.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientManagement extends JpaRepository<Patient, Long> {

}
