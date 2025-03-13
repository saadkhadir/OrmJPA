package org.example.patient;

import org.example.patient.Repository.ConsultationRepository;
import org.example.patient.Repository.MedecinRepository;
import org.example.patient.Repository.PatientRepository;
import org.example.patient.Repository.RendezVousRepository;
import org.example.patient.entities.*;
import org.example.patient.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {


    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService HospitalService , PatientRepository patientRepository , MedecinRepository medecinRepository , RendezVousRepository rendezVousRepository , ConsultationRepository consultationRepository) {
        return args -> {
            HospitalService.savePatient(new Patient("Yassine", Date.valueOf("2003-02-12"),true,80));
            HospitalService.savePatient(new Patient("Saad", Date.valueOf("2003-03-12"),false,14));
            HospitalService.savePatient(new Patient("Walid", Date.valueOf("2003-04-12"),true,15));
            List<Patient> patients = patientRepository.findAll();
            patients.forEach(patient -> System.out.println(patient.toString()));
            Patient patient=patientRepository.findById(Long.valueOf(1)).get();
            System.out.println(patient .getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.getScore());
            Patient patient2=patientRepository.findByMalade((false));
            patient2.setMalade(true);
            System.out.println(patient2 .getId());
            System.out.println(patient2.getNom());
            System.out.println(patient2.getDateNaissance());
            System.out.println(patient2.getScore());
            patientRepository.deleteById(Long.valueOf(2));

            Stream.of("TAHA","WAFAA","REDA").forEach(name -> {
                Medecin medecin= new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecin.setEmail(name + "@gmail.com");
                HospitalService.saveMedecin(medecin);
            });
           Patient patient3=patientRepository.findByNom("Yassine");

           Medecin medecin=medecinRepository.findByNom("TAHA");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new java.util.Date());
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient3);
            HospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findById(Long.valueOf(1)).get();
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new java.util.Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consu.... ");
            HospitalService.saveConsultation(consultation);
        };
    }
}
