/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.EnseignantClasseJury;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class EnseignantClasseJuryFacade extends AbstractFacade<EnseignantClasseJury> {

    @PersistenceContext(unitName = "GestionNoteUy1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnseignantClasseJuryFacade() {
        super(EnseignantClasseJury.class);
    }
    
}
