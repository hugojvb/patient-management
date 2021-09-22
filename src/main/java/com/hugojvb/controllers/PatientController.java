package com.hugojvb.controllers;

import com.hugojvb.models.Patient;
import com.hugojvb.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping
	public String patients(Model model) {
		model.addAttribute("patients", patientService.getAllPatients());

		return "patients";
	}

	@GetMapping("/add")
	public String addPatient(Model model) {
		Patient newPatient = new Patient();
		model.addAttribute("patient", newPatient);
		return "create_patient";
	}

	@PostMapping
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		patientService.savePatient(patient);
		return "redirect:/patients";
	}

}
