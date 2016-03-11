/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.model;

import java.io.Serializable;
import java.sql.Date;
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
@NamedQueries(@NamedQuery( name="Carro.getAll",query="SELECT e FROM Carro e" ))
@Table(name = "carros" ,schema = "consecionario")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String matricula;
    @Column
    private String modelo;
    @Column
    private String fabricante;
    @Column
    private Date fecha;
    @Column
    private int cilindraje;
    @Column
    private int potencia;
    @Column
    private int precio;    
    @Column
    private Boolean transmision;

    public Carro(String matricula, String modelo, String fabricante, Date fecha, int cilindraje, int potencia, int precio, Boolean transmision) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.fecha = fecha;
        this.cilindraje = cilindraje;
        this.potencia = potencia;
        this.precio = precio;
        this.transmision = transmision;
    }
    
    public Carro(){}

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Boolean getTransmision() {
        return transmision;
    }

    public void setTransmision(Boolean transmision) {
        this.transmision = transmision;
    }
    
    
    
    
}
