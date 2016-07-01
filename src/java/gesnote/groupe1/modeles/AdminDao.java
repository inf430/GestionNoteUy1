/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gesnote.groupe1.modeles;

import entities.Personne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class AdminDao {
    @PersistenceContext( unitName = "GestionNoteUy1PU" )
    private EntityManager em;
    
    public boolean connection( String login, String password){
        String Crequete = "SELECT u FROM personne u where u.login =:login AND u.password =:password";
        System.out.println(em.toString());
        Query  requete = em.createQuery(Crequete);
        requete.setParameter("login", login);
        requete.setParameter("password", password);
        try{
            Personne p = null;
            p = (Personne)requete.getSingleResult();
            return true;
        }catch( NoResultException e){
            e.printStackTrace();
        }
        return false;
    }
}

