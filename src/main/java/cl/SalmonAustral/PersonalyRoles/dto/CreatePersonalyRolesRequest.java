package cl.SalmonAustral.PersonalyRoles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreatePersonalyRolesRequest (
    @Positive(message = "El rut no puede estar vacío")
    int rut,

    @NotBlank(message = "El digito verificador no puede estar vacío")
    String dv,

    @NotBlank(message = "La especialidad no puede estar vacía")
    String especialidad,

    @NotBlank(message = "El primer nombre no puede estar vacio")
    String primerNombre,

    @NotBlank(message = "El segundo nombre no puede estar vacio")
    String segundoNombre,

    @NotBlank(message = "El apellido paterno no puede estar vacio")
    String apellidoPaterno,

    @NotBlank(message = "El apellido materno no puede estar vacio")
    String apellidoMaterno,

    @Positive(message = "El telefono no puede estar vacío")
    String telefono,

    @NotBlank(message = "El correo no puede estar vacía")
    String correo,

    @NotBlank(message = "La direccion no puede estar vacía")
    String direccion
){}
