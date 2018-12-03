/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.util.Calendar;

public class Licence {

    public Personne possesseur;

    public String numero;

    public Calendar delivrance;

    public int niveau;

    public Club club;

    public Licence(Personne possesseur, String numero, Calendar delivrance, int niveau, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.niveau = niveau;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public Calendar getDelivrance() {
        return delivrance;
    }

    public int getNiveau() {
        return niveau;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(Calendar d) {
        Calendar res = (Calendar) delivrance.clone();
        res.add(Calendar.YEAR, 1);
        if(d.after(res)){
            return false;
        } else {
    return true;
        }
    }
}
