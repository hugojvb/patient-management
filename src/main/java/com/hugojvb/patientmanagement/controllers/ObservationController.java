package com.hugojvb.patientmanagement.controllers;

import com.hugojvb.patientmanagement.models.Observation;
import com.hugojvb.patientmanagement.models.Patient;
import com.hugojvb.patientmanagement.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ObservationController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/patients/{id}/observations/add")
	public String addObservation(@PathVariable Long id, Model model) {
		Observation newObservation = new Observation();
		newObservation.setPatient(patientService.getPatientById(id));
		model.addAttribute("observation", newObservation);
		return "create_observation";
	}
}
