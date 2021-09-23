package com.hugojvb.patientmanagement.controllers;

import com.hugojvb.patientmanagement.models.Patient;
import com.hugojvb.patientmanagement.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/patients")
	public String patients(Model model) {
		model.addAttribute("patients", patientService.getAllPatients());

		return "patients";
	}

	@GetMapping("/patients/add")
	public String addPatient(Model model) {
		Patient newPatient = new Patient();
		model.addAttribute("patient", newPatient);
		return "create_patient";
	}

	@PostMapping("/patients")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		patientService.savePatient(patient);
		return "redirect:/patients";
	}

}
