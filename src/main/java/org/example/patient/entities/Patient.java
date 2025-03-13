package org.example.patient.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;



import java.util.Date;
@Entity @ToString


public class  Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;


public Patient(String nom, Date dateNaissance, boolean malade, int score) {
    this.nom = nom;
    this.dateNaissance = dateNaissance;
    this.malade = malade;
    this.score = score;

}

    public Patient() {

    }

    public Long getId() {
        return id;
    }
    public String getNom() {
    return nom;
    }
    public Date getDateNaissance() {return dateNaissance;}
    public boolean isMalade() {return malade;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public void setMalade(boolean malade) {this.malade = malade;}
    public void setNom(String nom) {this.nom = nom;}
    public void setId(Long id) {this.id = id;}
    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + nom + "', date_naissance=" + dateNaissance + ",score"+score;
    }



    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


}
