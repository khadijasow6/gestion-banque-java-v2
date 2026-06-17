/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
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
@Table(name = "utilisateurs")
@NamedQueries({
    @NamedQuery(name = "Utilisateurs.findAll", query = "SELECT u FROM Utilisateurs u"),
    @NamedQuery(name = "Utilisateurs.findById", query = "SELECT u FROM Utilisateurs u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateurs.findByNom", query = "SELECT u FROM Utilisateurs u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateurs.findByPrenom", query = "SELECT u FROM Utilisateurs u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateurs.findByEmail", query = "SELECT u FROM Utilisateurs u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateurs.findByUsername", query = "SELECT u FROM Utilisateurs u WHERE u.username = :username"),
    @NamedQuery(name = "Utilisateurs.findByPassword", query = "SELECT u FROM Utilisateurs u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateurs.findByRole", query = "SELECT u FROM Utilisateurs u WHERE u.role = :role"),
    @NamedQuery(name = "Utilisateurs.findByActif", query = "SELECT u FROM Utilisateurs u WHERE u.actif = :actif"),
    @NamedQuery(name = "Utilisateurs.findByCreatedAt", query = "SELECT u FROM Utilisateurs u WHERE u.createdAt = :createdAt")})
public class Utilisateurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @Column(name = "actif")
    private boolean actif;
    @Basic(optional = false)
    @Column(name = "premiere_connexion")
    private boolean premiereConnexion;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creePar", fetch = FetchType.LAZY)
    private List<Clients> clientsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ouvertPar", fetch = FetchType.LAZY)
    private List<Comptes> comptesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traitePar", fetch = FetchType.LAZY)
    private List<Transactions> transactionsList;

    public Utilisateurs() {
    }

    public Utilisateurs(Integer id) {
        this.id = id;
    }

    public Utilisateurs(Integer id, String nom, String prenom, String email, String username, String password, String role, boolean actif, Date createdAt) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.actif = actif;
        this.createdAt = createdAt;
    }
    public Utilisateurs(String nom, String prenom, String email, String username, String password, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.actif = true;
        this.premiereConnexion = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
public boolean getPremiereConnexion() {
    return premiereConnexion;
}

public void setPremiereConnexion(boolean premiereConnexion) {
    this.premiereConnexion = premiereConnexion;
}
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Clients> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Clients> clientsList) {
        this.clientsList = clientsList;
    }

    public List<Comptes> getComptesList() {
        return comptesList;
    }

    public void setComptesList(List<Comptes> comptesList) {
        this.comptesList = comptesList;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
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
        if (!(object instanceof Utilisateurs)) {
            return false;
        }
        Utilisateurs other = (Utilisateurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Utilisateurs[ id=" + id + " ]";
    }
    
}
