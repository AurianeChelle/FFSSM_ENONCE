/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    public ArrayList<Plongeur> participants;

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
        participants = new ArrayList<>();
    }

    public void ajouteParticipant(Plongeur participant) {
        participants.add(participant);	    
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
        for(Plongeur p : participants){
            if(!p.derniereLicence().estValide(date)){
                return false;
            }
        }
        return true;
    }


}
