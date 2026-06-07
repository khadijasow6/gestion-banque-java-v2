/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import enums.StatutCompte;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "comptes")
@NamedQueries({
    @NamedQuery(name = "Comptes.findAll", query = "SELECT c FROM Comptes c"),
    @NamedQuery(name = "Comptes.findById", query = "SELECT c FROM Comptes c WHERE c.id = :id"),
    @NamedQuery(name = "Comptes.findByNumeroCompte", query = "SELECT c FROM Comptes c WHERE c.numeroCompte = :numeroCompte"),
    @NamedQuery(name = "Comptes.findByTypeCompte", query = "SELECT c FROM Comptes c WHERE c.typeCompte = :typeCompte"),
    @NamedQuery(name = "Comptes.findBySolde", query = "SELECT c FROM Comptes c WHERE c.solde = :solde"),
    @NamedQuery(name = "Comptes.findByStatut", query = "SELECT c FROM Comptes c WHERE c.statut = :statut"),
    @NamedQuery(name = "Comptes.findByCreatedAt", query = "SELECT c FROM Comptes c WHERE c.createdAt = :createdAt")})
public class Comptes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_compte")
    private String numeroCompte;
    @Basic(optional = false)
    @Column(name = "type_compte")
    private String typeCompte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "solde")
    private BigDecimal solde;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clients clientId;
    @JoinColumn(name = "ouvert_par", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utilisateurs ouvertPar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compteSourceId", fetch = FetchType.LAZY)
    private List<Transactions> transactionsList;
    @OneToMany(mappedBy = "compteDestinationId", fetch = FetchType.LAZY)
    private List<Transactions> transactionsList1;

    public Comptes() {
    }

    public Comptes(Integer id) {
        this.id = id;
    }

    public Comptes(Integer id, String numeroCompte, String typeCompte, BigDecimal solde, String statut, Date createdAt) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.statut = statut;
        this.createdAt = createdAt;
    }

    public Comptes(String numeroCompte, String typeCompte, BigDecimal solde, Clients client, Utilisateurs user) {
        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.statut = StatutCompte.ACTIF.getValue();
        this.createdAt = new Date();
        this.clientId = client;
        this.ouvertPar = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
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

    public Clients getClient() {
        return clientId;
    }

    public void setClient(Clients clientId) {
        this.clientId = clientId;
    }

    public Utilisateurs getOuvertPar() {
        return ouvertPar;
    }

    public void setOuvertPar(Utilisateurs ouvertPar) {
        this.ouvertPar = ouvertPar;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public List<Transactions> getTransactionsList1() {
        return transactionsList1;
    }

    public void setTransactionsList1(List<Transactions> transactionsList1) {
        this.transactionsList1 = transactionsList1;
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
        if (!(object instanceof Comptes)) {
            return false;
        }
        Comptes other = (Comptes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Comptes[ id=" + id + " ]";
    }

}
