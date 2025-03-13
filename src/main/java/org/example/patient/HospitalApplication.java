package org.example.patient;

import org.example.patient.Repository.MedecinRepository;
import org.example.patient.Repository.PatientRepository;
import org.example.patient.Repository.RendezVousRepository;
import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.example.patient.entities.RendezVous;
import org.example.patient.entities.StatusRDV;
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
    public CommandLineRunner commandLineRunner(PatientRepository patientRepository , MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository) {
        return args -> {
            patientRepository.save(new Patient("Yassine", Date.valueOf("2003-02-12"),true,80));
            patientRepository.save(new Patient("Saad", Date.valueOf("2003-03-12"),false,14));
            patientRepository.save(new Patient("Walid", Date.valueOf("2003-04-12"),true,15));
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
            patientRepository.deleteById(Long.valueOf(1));

            Stream.of("TAHA","WAFAA","REDA").forEach(name -> {
                Medecin medecin= new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecin.setEmail(name + "@gmail.com");
                medecinRepository.save(medecin);
            });
           Patient patient3=patientRepository.findByNom("Yassine");

           Medecin medecin=medecinRepository.findByNom("TAHA");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new java.util.Date());
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient3);
            rendezVousRepository.save(rendezVous);
        };
    }
}
