/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author HP
 */
public enum StatutTransaction {
    SUCCES("succes"),
    ECHEC("echec"),
    ANNULE("annule");
    private String value;
    StatutTransaction(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public static StatutTransaction fromValue(String value){
        for (StatutTransaction statutTransaction : StatutTransaction.values() ) {
            if (statutTransaction.value.equals(value)){
                return statutTransaction;
            }
            
        }
        throw new IllegalArgumentException("Valeur invalide pour StatutCompte "+ value);
    }
    
}
