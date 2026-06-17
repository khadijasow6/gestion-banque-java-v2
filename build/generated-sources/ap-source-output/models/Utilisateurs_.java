package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Clients;
import models.Comptes;
import models.Transactions;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-06-15T21:17:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Utilisateurs.class)
public class Utilisateurs_ { 

    public static volatile SingularAttribute<Utilisateurs, String> role;
    public static volatile ListAttribute<Utilisateurs, Comptes> comptesList;
    public static volatile SingularAttribute<Utilisateurs, Boolean> actif;
    public static volatile ListAttribute<Utilisateurs, Clients> clientsList;
    public static volatile SingularAttribute<Utilisateurs, String> nom;
    public static volatile ListAttribute<Utilisateurs, Transactions> transactionsList;
    public static volatile SingularAttribute<Utilisateurs, Boolean> premiereConnexion;
    public static volatile SingularAttribute<Utilisateurs, Date> createdAt;
    public static volatile SingularAttribute<Utilisateurs, String> password;
    public static volatile SingularAttribute<Utilisateurs, Integer> id;
    public static volatile SingularAttribute<Utilisateurs, String> prenom;
    public static volatile SingularAttribute<Utilisateurs, String> email;
    public static volatile SingularAttribute<Utilisateurs, String> username;

}