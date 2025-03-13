package org.example.patient.service;

import jakarta.transaction.Transactional;
import org.example.patient.Repository.ConsultationRepository;
import org.example.patient.Repository.MedecinRepository;
import org.example.patient.Repository.PatientRepository;
import org.example.patient.Repository.RendezVousRepository;
import org.example.patient.entities.Consultation;
import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.example.patient.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private final RendezVousRepository rendezVousRepository;
    private PatientRepository patientRepository;
    private ConsultationRepository consultationRepository;
    private MedecinRepository medecinRepository;


    public HospitalServiceImpl(PatientRepository patientRepository , ConsultationRepository consultationRepository , MedecinRepository medecinRepository , RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
