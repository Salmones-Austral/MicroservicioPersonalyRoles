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
    @Column(name="id")
    private int id;

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

    //get y set paa evitar errores en el mapper
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getRut() {
        return rut;
    }
    public void setRut(int rut) {
        this.rut = rut;
    }
    
    public String getDv() {
        return dv;
    }
    public void setDv(String dv) {
        this.dv = dv;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    public void getEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String getPrimerNombre() {
        return primerNombre;
    }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    
    public String getSegundoNombre() {
        return segundoNombre;
    }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
