package com.hugojvb.patientmanagement.services.Impl;

import java.util.List;

import com.hugojvb.patientmanagement.models.Patient;
import com.hugojvb.patientmanagement.models.User;
import com.hugojvb.patientmanagement.repositories.PatientRepository;
import com.hugojvb.patientmanagement.services.PatientService;
import com.hugojvb.patientmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private UserService userService;

	@Override
	public List<Patient> getAllPatients() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		User user = userService.getUserByEmail(email);

		return patientRepository.findAllByUserId(user.getId());
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}
