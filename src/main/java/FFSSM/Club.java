/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    public TreeSet<Plongee> plongees;

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
        plongees = new TreeSet<>();
    }

    public Set<Plongee> plongeesNonConformes() {
        TreeSet<Plongee>res = new TreeSet<>();
        for(Plongee p : plongees){
            if (!p.estConforme()){
                res.add(p);
            }
        }
        if(res.isEmpty()){
            return null;
        }
        return res;
    }

    public void organisePlongee(Plongee p) {
        plongees.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
