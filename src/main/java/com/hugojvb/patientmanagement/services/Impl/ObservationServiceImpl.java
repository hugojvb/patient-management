package com.hugojvb.patientmanagement.services.Impl;

import com.hugojvb.patientmanagement.models.Observation;
import com.hugojvb.patientmanagement.repositories.ObservationRepository;
import com.hugojvb.patientmanagement.services.ObservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationServiceImpl implements ObservationService {

	@Autowired
	private ObservationRepository observationRepository;

	@Override
	public Observation saveObservation(Observation observation) {
		return observationRepository.save(observation);
	}

	@Override
	public Observation updateObservation(Observation observation) {
		return observationRepository.save(observation);
	}

	@Override
	public Observation getObservationById(Long id) {
		return observationRepository.findById(id).get();
	}

	@Override
	public void deleteObservation(Long id) {
		observationRepository.deleteById(id);
	}
}
