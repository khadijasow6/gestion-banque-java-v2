/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author HP
 */
public enum TypeCompte {
    COURANT("courant"),
    EPARGNE("epargne");
    private String value;
    TypeCompte(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public static TypeCompte fromValue(String value){
        for (TypeCompte typeCompte : TypeCompte.values() ) {
            if (typeCompte.value.equals(value)){
                return typeCompte;
            }
            
        }
        throw new IllegalArgumentException("Valeur invalide pour type de compte "+ value);
    }
    
}
