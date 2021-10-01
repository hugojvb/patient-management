package com.hugojvb.patientmanagement.controllers;

import com.hugojvb.patientmanagement.models.Patient;
import com.hugojvb.patientmanagement.models.User;
import com.hugojvb.patientmanagement.services.PatientService;
import com.hugojvb.patientmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private UserService userService;

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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();

		patient.setUser(userService.getUserByEmail(email));
		patientService.savePatient(patient);
		return "redirect:/patients";
	}

	@GetMapping("/{id}")
	public String patientFile(@PathVariable Long id, Model model) {
		model.addAttribute("patient", patientService.getPatientById(id));
		return "patient_file";
	}

	@GetMapping("/{id}/edit")
	public String editPatient(@PathVariable Long id, Model model) {
		model.addAttribute("patient", patientService.getPatientById(id));
		return "edit_patient";
	}

	@PostMapping("/{id}")
	public String updatePatient(@PathVariable Long id, @ModelAttribute("patient") Patient patient) {
		Patient patientToUpdate = patientService.getPatientById(id);
		patientToUpdate.setId(id);
		patientToUpdate.setAge(patient.getAge());
		patientToUpdate.setName(patient.getName());
		patientToUpdate.setScholarity(patient.getScholarity());
		patientToUpdate.setState(patient.getState());
		patientToUpdate.setObservations(patient.getObservations());

		patientService.updatePatient(patientToUpdate);
		return "redirect:/patients/{id}";
	}

	@GetMapping("/{id}/delete")
	public String deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
		return "redirect:/patients";
	}
}
