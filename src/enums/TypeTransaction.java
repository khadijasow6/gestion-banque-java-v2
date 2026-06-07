/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author HP
 */
public enum TypeTransaction {
    DEPOT("depot"),
    RETRAIT("retrait"),
    VIRMENT("virment");
    private String value;
    TypeTransaction(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public static TypeTransaction fromValue(String value){
        for (TypeTransaction typeTransaction : TypeTransaction.values() ) {
            if (typeTransaction .value.equals(value)){
                return typeTransaction ;
            }
            
        }
        throw new IllegalArgumentException("Valeur invalide pour typeTransaction  "+ value);
    }
    
}
