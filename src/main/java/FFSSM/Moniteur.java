/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    public ArrayList<Embauche> embauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
        embauches=new ArrayList <>();
    }

    public Club employeur() {
        if (embauches.isEmpty()){
            return null;
        }else {
        return embauches.get(embauches.size()-1).getEmployeur();
        }
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {
        Embauche e = new Embauche(debutNouvelle,this,employeur);
        embauches.add(e);	    
    }

    public List<Embauche> emplois() {
        return embauches;
    }

}
