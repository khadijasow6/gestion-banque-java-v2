/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author HP
 */
public class CompteMapper {
    public static CompteDTO toDto(Comptes compte){
        if(compte == null){
            return null;
        }
        CompteDTO dto = new CompteDTO();
        dto.setNumeroCompte(compte.getNumeroCompte());
        dto.setStatut(compte.getStatut());
        dto.setSolde(String.format("%.2f FCFA", compte.getSolde()));
        dto.setTypeCompte(compte.getTypeCompte());
        if(compte.getClient()!= null){
            dto.setNomComplet(compte.getClient().getPrenom()+" "+ compte.getClient().getNom());
        }
        if(compte.getOuvertPar()!= null){
            dto.setCreePar(compte.getOuvertPar().getPrenom()+ " "+ compte.getClient().getNom());
        }
        return dto;
    }
    public static List<CompteDTO> toDtoList(List<Comptes> compteList){
        if(compteList== null){
            return List.of();
        }
        return compteList.stream().map(CompteMapper::toDto).collect(Collectors.toList());
    }
}

