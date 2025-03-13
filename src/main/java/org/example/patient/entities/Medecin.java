package org.example.patient.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity  @NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy ="medecin",fetch= FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getSpecialite() {return specialite;}
    public void setSpecialite(String specialite) {this.specialite = specialite;}

    public Collection<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(Collection<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }
}
