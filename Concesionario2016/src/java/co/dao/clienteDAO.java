/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josepplloo
 */
@Stateless
public class clienteDAO implements clienteDAOLocal {
    
    @PersistenceContext(unitName = "Concesionario2016PU")
    private EntityManager em;


    @Override
    
    public void addCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void editCliente(Cliente cliente) {
    em.merge(cliente);
    }

    @Override
    public void deleteCliente(int idcliente) {
    em.remove(getCliente(idcliente));
    }

    @Override
    public Cliente getCliente(int idcliente) {
    return em.find(Cliente.class, idcliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
    return em.createNamedQuery("Cliente.getAll").getResultList();
    }

}
