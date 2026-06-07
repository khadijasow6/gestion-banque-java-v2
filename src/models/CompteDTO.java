/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.sun.jdi.TypeComponent;
import enums.TypeCompte;
import java.math.BigDecimal;

/**
 *
 * @author HP
 */
public class CompteDTO {
    private String numeroCompte;
    private String nomComplet;
    private String typeCompte;
    private String solde;
    private String creePar;
    private String statut;

    public CompteDTO(String numeroCompte, String nomComplet, TypeCompte type, BigDecimal solde, String creePar, String statut) {
        this.numeroCompte = numeroCompte;
        this.nomComplet = nomComplet;
        this.typeCompte = type==TypeCompte.COURANT? "Courant": "Epargne";
        this.solde = String.format("%.2f FCFA", solde);
        this.creePar = creePar;
        this.statut = statut;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public String getSolde() {
        return solde;
    }

    public String getCreePar() {
        return creePar;
    }

    public String getStatut() {
        return statut;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public void setCreePar(String creePar) {
        this.creePar = creePar;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public CompteDTO() {
    }
    
    
}
