/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author HP
 */
public enum StatutCompte {
    ACTIF("actif"),
    INACTIF("inactif"),
    SUSPENDU("suspendu"),
    CLOTURE("cloture");
    private String value;
    StatutCompte(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public static StatutCompte fromValue(String value){
        for (StatutCompte statutCompte : StatutCompte.values() ) {
            if (statutCompte.value.equals(value)){
                return statutCompte;
            }
            
        }
        throw new IllegalArgumentException("Valeur invalide pour StatutCompte "+ value);
    }
    
}
