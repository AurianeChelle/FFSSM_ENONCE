/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author achelle
 */
public class FFSSMTest {
    Calendar naissance;
    Calendar delivrance;
    Moniteur m1;
    Plongeur p1;
    Plongeur p2;
    Club club1;
    Licence l1;
    Licence l2;
    
    public FFSSMTest() {
        
    }

    
    @Before
    public void setUp() {
        naissance = Calendar.getInstance();
        naissance.set(1980, 11, 07);
        delivrance = Calendar.getInstance();
        delivrance.set(2018, 11, 20);
        m1 = new Moniteur ("111","Dupont","Jean","adresse 1","0612547896",naissance,111);
        p1 = new Plongeur("222","Luito","Harmant","adresse 2","065221477",naissance,2,GroupeSanguin.APLUS);
        p2 = new Plongeur("333","Charpent","Louis","adresse ","0644985623",naissance,3,GroupeSanguin.BMOINS); 
        club1 = new Club(m1, "ouiClub", "0623544187");
        l1 = new Licence (m1, "1", delivrance, 1, club1);
        l2 = new Licence (m1, "2", delivrance, 1, club1);
        p1.ajouterLicence(l1);
        p2.ajouterLicence(l2);
 
    }
    @Test
    public void testLicence(){
        Calendar d = Calendar.getInstance();
        d.set(2018, 11, 21);
        assertTrue(l1.estValide(d));
        d.set(2019, 11, 21);
        assertFalse(l1.estValide(d));
    }
    
    @Test
    public void testPlongeur(){
        assertEquals(l1,p1.derniereLicence());
    }
    
    @Test
    public void testMoniteur(){
        Embauche e = new Embauche(delivrance, m1,club1);
        ArrayList <Embauche> es = new ArrayList<>();
        es.add(e);
        assertNull(m1.employeur());
        m1.nouvelleEmbauche(club1, delivrance);
        assertEquals(club1,m1.employeur());
    }
    
    @Test
    public void testPlongee(){
        Calendar d = Calendar.getInstance();
        d.set(2018, 11, 21);
        Site s = new Site("castres","commune d'albi");
        Plongee p = new Plongee(s,m1,d,30,50);
        p.ajouteParticipant(p1);
        assertTrue(p.estConforme());
        d.set(2019, 11, 21);
        assertFalse(p.estConforme());
    }
    
    @Test
    public void testClub(){
        assertNull(club1.plongeesNonConformes());
    }
    
    @Test
    public void testEmbauche(){
        Embauche e = new Embauche(delivrance, m1,club1);
        Calendar d = Calendar.getInstance();
        d.set(2018, 11, 21);
        assertFalse(e.estTerminee());
        e.terminer(d);
        assertTrue(e.estTerminee());
    }
}
