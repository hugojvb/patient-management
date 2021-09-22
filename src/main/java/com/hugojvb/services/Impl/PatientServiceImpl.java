package com.hugojvb.services.Impl;

import java.util.List;

import com.hugojvb.models.Patient;
import com.hugojvb.repositories.PatientRepository;
import com.hugojvb.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

}
