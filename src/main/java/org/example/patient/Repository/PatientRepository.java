package org.example.patient.Repository;

import org.example.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * FROM patient WHERE malade = :malade LIMIT 1", nativeQuery = true)
    Patient findByMalade(@Param("malade") boolean malade);
    Patient findByNom(String name);
}
