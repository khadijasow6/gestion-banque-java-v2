/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author HP
 */
public enum Role {
    GESTIONNAIRE("gestionnaire"),
    CAISSIER("caissier");
    private String value;
    Role(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public static Role fromValue(String value){
        for (Role role : Role.values() ) {
            if (role.value.equals(value)){
                return role;
            }
            
        }
        throw new IllegalArgumentException("Valeur invalide pour role "+ value);
    }
    
}
