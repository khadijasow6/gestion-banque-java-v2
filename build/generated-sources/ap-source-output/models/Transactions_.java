package models;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Comptes;
import models.Utilisateurs;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-05T18:33:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, String> reference;
    public static volatile SingularAttribute<Transactions, Date> createdAt;
    public static volatile SingularAttribute<Transactions, Comptes> compteDestinationId;
    public static volatile SingularAttribute<Transactions, Comptes> compteSourceId;
    public static volatile SingularAttribute<Transactions, Utilisateurs> traitePar;
    public static volatile SingularAttribute<Transactions, BigDecimal> montant;
    public static volatile SingularAttribute<Transactions, Integer> id;
    public static volatile SingularAttribute<Transactions, String> motif;
    public static volatile SingularAttribute<Transactions, String> type;
    public static volatile SingularAttribute<Transactions, String> statut;

}