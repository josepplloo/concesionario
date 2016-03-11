/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.model.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josepplloo
 */
@Local
public interface clienteDAOLocal {
    
    public void addCliente(Cliente cliente);
    
    public void editCliente(Cliente cliente);

    public void deleteCliente(int idcliente);
    
    public Cliente getCliente(int idcliente);
    
    public List<Cliente> getAllClientes();
    
    
}
