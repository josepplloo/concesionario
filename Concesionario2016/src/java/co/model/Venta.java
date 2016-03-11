/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author josepplloo
 */

@Entity
@Table(name="ventas")
@NamedQueries(@NamedQuery(name="Venta.getAll",query = "SELECT e FROM Venta e"))
public class Venta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int ventaid;
    @Column
    private String matricula;
    @Column
    private int clienteid;

    public Venta(int ventaid, String matricula, int clienteid) {
        this.ventaid = ventaid;
        this.matricula = matricula;
        this.clienteid = clienteid;
    }
    
    public Venta(){}

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }
    
    
}
