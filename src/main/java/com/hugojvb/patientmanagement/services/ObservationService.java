package com.hugojvb.patientmanagement.services;

import com.hugojvb.patientmanagement.models.Observation;

import org.springframework.stereotype.Service;

@Service
public interface ObservationService {
	public Observation saveObservation(Observation observation);

	public Observation updateObservation(Observation observation);

	public Observation getObservationById(Long id);

	public void deleteObservation(Long id);
}
