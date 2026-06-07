/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "transactions")
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id"),
    @NamedQuery(name = "Transactions.findByReference", query = "SELECT t FROM Transactions t WHERE t.reference = :reference"),
    @NamedQuery(name = "Transactions.findByType", query = "SELECT t FROM Transactions t WHERE t.type = :type"),
    @NamedQuery(name = "Transactions.findByMontant", query = "SELECT t FROM Transactions t WHERE t.montant = :montant"),
    @NamedQuery(name = "Transactions.findByMotif", query = "SELECT t FROM Transactions t WHERE t.motif = :motif"),
    @NamedQuery(name = "Transactions.findByStatut", query = "SELECT t FROM Transactions t WHERE t.statut = :statut"),
    @NamedQuery(name = "Transactions.findByCreatedAt", query = "SELECT t FROM Transactions t WHERE t.createdAt = :createdAt")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "montant")
    private BigDecimal montant;
    @Column(name = "motif")
    private String motif;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "compte_source_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Comptes compteSourceId;
    @JoinColumn(name = "compte_destination_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comptes compteDestinationId;
    @JoinColumn(name = "traite_par", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utilisateurs traitePar;

    public Transactions() {
    }

    public Transactions(Integer id) {
        this.id = id;
    }

    public Transactions(Integer id, String reference, String type, BigDecimal montant, String statut, Date createdAt) {
        this.id = id;
        this.reference = reference;
        this.type = type;
        this.montant = montant;
        this.statut = statut;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Comptes getCompteSourceId() {
        return compteSourceId;
    }

    public void setCompteSourceId(Comptes compteSourceId) {
        this.compteSourceId = compteSourceId;
    }

    public Comptes getCompteDestinationId() {
        return compteDestinationId;
    }

    public void setCompteDestinationId(Comptes compteDestinationId) {
        this.compteDestinationId = compteDestinationId;
    }

    public Utilisateurs getTraitePar() {
        return traitePar;
    }

    public void setTraitePar(Utilisateurs traitePar) {
        this.traitePar = traitePar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Transactions[ id=" + id + " ]";
    }
    
}
