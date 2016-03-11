package co.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-11T09:12:12")
@StaticMetamodel(Carro.class)
public class Carro_ { 

    public static volatile SingularAttribute<Carro, Date> fecha;
    public static volatile SingularAttribute<Carro, Integer> potencia;
    public static volatile SingularAttribute<Carro, Integer> cilindraje;
    public static volatile SingularAttribute<Carro, Integer> precio;
    public static volatile SingularAttribute<Carro, Boolean> transmision;
    public static volatile SingularAttribute<Carro, String> matricula;
    public static volatile SingularAttribute<Carro, String> fabricante;
    public static volatile SingularAttribute<Carro, String> modelo;

}