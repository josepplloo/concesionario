/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.model.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josepplloo
 */
@Stateless
public class ventaDAO implements ventaDAOLocal {
    
    @PersistenceContext(unitName = "Concesionario2016PU")
    private EntityManager em;

    @Override
    public void addVenta(Venta venta) {
    em.persist(venta);
    }

    @Override
    public void editVenta(Venta venta) {
    em.merge(venta);
    }

    @Override
    public void deleteVenta(int idventa) {
    em.remove(getVenta(idventa));
    }
    

    @Override
    public Venta getVenta(int idVenta) {
    return em.find(Venta.class, idVenta);
    }

    @Override
    public List<Venta> getAllVentas() {
    return em.createNamedQuery("Venta.getAll").getResultList();
    }


}
