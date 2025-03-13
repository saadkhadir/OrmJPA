package org.example.patient.web;

import org.example.patient.Repository.PatientRepository;
import org.example.patient.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")
        public List<Patient> PatientList() {
        return patientRepository.findAll();
        }

}
