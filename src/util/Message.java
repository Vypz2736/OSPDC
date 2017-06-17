/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Vypz
 */
public class Message {
    public enum TypeMessage {
        SAISIEFINIE,
        CASECLIQUEE,
        DEPLACER,
        SEDEPLACER,
        ASSECHER,
        PASSER,
        DONNER,
        TRESOR;
    }
    
    private TypeMessage type;
    private int colonne;
    private int ligne;
    private int niveau;
    
    public Message(TypeMessage t, int l, int c) {
        type = t;
        colonne = c;
        ligne = l;
    }
    
    public Message(TypeMessage t) {
        type = t;
    }
    
    public Message(TypeMessage t, int n) {
        type = t;
        niveau = n+1;
    }

    /**
     * @return the type
     */
    public TypeMessage getType() {
        return type;
    }

    /**
     * @return the colonne
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * @return the ligne
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * @return the niveau
     */
    public int getNiveau() {
        return niveau;
    }
}
