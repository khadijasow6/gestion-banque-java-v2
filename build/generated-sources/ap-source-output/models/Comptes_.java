package models;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Clients;
import models.Transactions;
import models.Utilisateurs;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-06-15T21:17:29", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Comptes.class)
public class Comptes_ { 

    public static volatile SingularAttribute<Comptes, Utilisateurs> ouvertPar;
    public static volatile SingularAttribute<Comptes, String> numeroCompte;
    public static volatile SingularAttribute<Comptes, Date> createdAt;
    public static volatile SingularAttribute<Comptes, Clients> clientId;
    public static volatile SingularAttribute<Comptes, String> typeCompte;
    public static volatile SingularAttribute<Comptes, BigDecimal> solde;
    public static volatile SingularAttribute<Comptes, Integer> id;
    public static volatile ListAttribute<Comptes, Transactions> transactionsList;
    public static volatile SingularAttribute<Comptes, String> statut;
    public static volatile ListAttribute<Comptes, Transactions> transactionsList1;

}