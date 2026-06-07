package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Comptes;
import models.Utilisateurs;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-05T18:33:10", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile SingularAttribute<Clients, Date> createdAt;
    public static volatile ListAttribute<Clients, Comptes> comptesList;
    public static volatile SingularAttribute<Clients, String> adresse;
    public static volatile SingularAttribute<Clients, String> cin;
    public static volatile SingularAttribute<Clients, String> telephone;
    public static volatile SingularAttribute<Clients, Integer> id;
    public static volatile SingularAttribute<Clients, String> nom;
    public static volatile SingularAttribute<Clients, String> prenom;
    public static volatile SingularAttribute<Clients, Utilisateurs> creePar;
    public static volatile SingularAttribute<Clients, String> email;

}