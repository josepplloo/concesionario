/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.model.Carro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josepplloo
 */
@Stateless
public class carroDAO implements carroDAOLocal {

    @PersistenceContext(unitName = "Concesionario2016PU")
    private EntityManager em;

    
    @Override
    public void addCarro(Carro carro){
        em.persist(carro);
    }
    
    @Override
    public void editCarro(Carro carro){
        em.merge(carro);
    }
    
    @Override
    public void deleteCarro(String matricula){
    em.remove(getCarro(matricula));
    }
    
    
    @Override
    public Carro getCarro(String matricula){
    return em.find(Carro.class, matricula);
    }
    
    @Override
    public List<Carro> getAllCarros(){
    return em.createNamedQuery("Carro.getAll").getResultList();
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
