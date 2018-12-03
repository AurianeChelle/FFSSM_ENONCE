package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;

public class Plongeur extends Personne{
    private int niveau;
    private GroupeSanguin GS;
    private ArrayList<Licence> licences; 
    
    public Plongeur (String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau, GroupeSanguin gs){
        super(numeroINSEE, nom, prenom, adresse, telephone,naissance);
        this.niveau =niveau;
        GS=gs;
        licences=new ArrayList<>();
    }
    
    public void ajouterLicence(Licence l){
        licences.add(l);
    }
    
    public Licence derniereLicence(){
        return licences.get(licences.size()-1);
    }

}
