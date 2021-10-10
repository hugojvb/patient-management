package com.hugojvb.patientmanagement.controllers;

import com.hugojvb.patientmanagement.models.Observation;
import com.hugojvb.patientmanagement.services.ObservationService;
import com.hugojvb.patientmanagement.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ObservationController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private ObservationService observationService;

	@GetMapping("/patients/{id}/observations/add")
	public String addObservation(@PathVariable Long id, Model model) {
		Observation newObservation = new Observation();
		newObservation.setPatient(patientService.getPatientById(id));
		model.addAttribute("newObservation", newObservation);
		return "create_observation";
	}

	@PostMapping("/patients/{id}/observations")
	public String saveObservation(@PathVariable Long id, @ModelAttribute("newObservation") Observation newObservation) {
		newObservation.setPatient(patientService.getPatientById(id));
		newObservation.setId(null);
		observationService.saveObservation(newObservation);
		return "redirect:/patients/{id}";
	}

	@GetMapping("/patients/{id}/observations/{observationId}/edit")
	public String editObservation(@PathVariable("id") Long id, @PathVariable("observationId") Long observationId,
			Model model) {
		model.addAttribute("observation", observationService.getObservationById(observationId));
		return "edit_observation";
	}

	@PostMapping("/patients/{id}/observations/{observationId}")
	public String updateObservation(@PathVariable Long id, @PathVariable Long observationId,
			@ModelAttribute("observation") Observation observation) {
		Observation observationToUpdate = observationService.getObservationById(observationId);
		observationToUpdate.setId(observationId);
		observationToUpdate.setNote(observation.getNote());
		observationToUpdate.setCreationDate(observation.getCreationDate());
		observationToUpdate.setModificationDate(observation.getModificationDate());
		observationToUpdate.setPatient(patientService.getPatientById(id));

		observationService.updateObservation(observationToUpdate);
		return "redirect:/patients/{id}";
	}

	@GetMapping("/patients/{id}/observations/{observationId}/delete")
	public String deleteObservation(@PathVariable Long id, @PathVariable Long observationId) {
		observationService.deleteObservation(observationId);
		return "redirect:/patients/{id}";
	}
}
