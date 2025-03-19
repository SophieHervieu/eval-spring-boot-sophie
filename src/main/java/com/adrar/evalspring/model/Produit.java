package com.adrar.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom", nullable=false, length=50)
    @NotBlank(message="Le nom du produit doit être renseigné")
    @Size(min=3, message="Le nom du produit doit faire au minimum 3 caractères")
    private String nom;

    @Column(name="prix", nullable=false)
    @NotBlank(message="Le prix du produit doit être renseigné")
    @Min(value=1, message="Le prix du produit doit être d'au moins 1 euro")
    private Double prix;

    public Produit() {}

    public Produit(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
