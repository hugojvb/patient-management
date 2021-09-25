package com.hugojvb.patientmanagement.services;

import java.util.List;

import com.hugojvb.patientmanagement.models.Patient;

public interface PatientService {
	List<Patient> getAllPatients();

	Patient savePatient(Patient patient);

	Patient getPatientById(Long id);

	Patient updatePatient(Patient patient);

	void deletePatient(Long id);
}
