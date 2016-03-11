/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.model.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josepplloo
 */
@Local
public interface ventaDAOLocal {
    
        public void addVenta(Venta venta);

        public void editVenta(Venta venta);
        
        public void deleteVenta(int idventa);
        
        public Venta getVenta(int idVenta);
        
        public List<Venta> getAllVentas();


    
}
