package com.hugojvb.services.Impl;

import java.util.List;

import com.hugojvb.models.Patient;
import com.hugojvb.repositories.PatientRepository;
import com.hugojvb.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {

        return null;
    }
}
