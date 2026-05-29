package cl.SalmonAustral.PersonalyRoles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TablaPersonal")
public class PersonalyRoles {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_mrt")
    private int idMrt;

    @Column(name="idPersonal",nullable=false, length = 20)
    private int idPersonal;

    @Column(name="rut",nullable=false, length = 8)
    private int rut;

    @Column(name="dv",nullable=false, length = 1)
    private String dv;

    @Column(name="especialidad",nullable=false, length = 20)
    private String especialidad;

    @Column(name="primerNombre",nullable=false, length = 30)
    private String primerNombre;
    
    @Column(name="segundoNombre",nullable=false, length = 30)
    private String segundoNombre;

    @Column(name="apellidoPaterno",nullable=false, length = 30)
    private String apellidoPaterno;

    @Column(name="apellidoMaterno",nullable=false, length = 30)
    private String apellidoMaterno;

    @Column(name="telefono",nullable=false, length = 9)
    private String telefono;

    @Column(name="correo",nullable=false, length = 100)
    private String correo;

    @Column(name="direccion",nullable=false, length = 100)
    private String direccion;

}
