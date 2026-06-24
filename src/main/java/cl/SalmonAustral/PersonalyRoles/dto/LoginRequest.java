package cl.SalmonAustral.PersonalyRoles.dto;
//llamar a los datos entrantes
import lombok.Data;
@Data
public class LoginRequest {
    private int rut;
    private String dv; 
    private String primerNombre;
}