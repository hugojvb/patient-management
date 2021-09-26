package com.hugojvb.patientmanagement.services;

import com.hugojvb.patientmanagement.models.Observation;

import org.springframework.stereotype.Service;

@Service
public interface ObservationService {
	public Observation saveObservation(Observation observation);
}
