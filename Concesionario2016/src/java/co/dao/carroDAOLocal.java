/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.model.Carro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josepplloo
 */
@Local
public interface carroDAOLocal {

    public void addCarro(Carro carro);
    
    public void editCarro(Carro carro);
    
    public void deleteCarro(String matricula);
    
    public Carro getCarro(String matricula);
    
    public List<Carro> getAllCarros();
    
    
}
