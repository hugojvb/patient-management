package com.hugojvb.patientmanagement.services.Impl;

import com.hugojvb.patientmanagement.models.Observation;
import com.hugojvb.patientmanagement.repositories.ObservationRepository;
import com.hugojvb.patientmanagement.services.ObservationService;

import org.springframework.beans.factory.annotation.Autowired;

public class ObservationServiceImpl implements ObservationService {

	@Autowired
	private ObservationRepository observationRepository;

	@Override
	public Observation saveObservation(Observation observation) {
		return observationRepository.save(observation);
	}
}
