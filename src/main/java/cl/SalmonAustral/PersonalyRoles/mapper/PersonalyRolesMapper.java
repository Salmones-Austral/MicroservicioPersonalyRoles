package cl.SalmonAustral.PersonalyRoles.mapper;

import cl.SalmonAustral.PersonalyRoles.dto.CreatePersonalyRolesRequest;
import cl.SalmonAustral.PersonalyRoles.dto.UpdatePersonalyRolesRequest;
import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;

/**
 * Mapper para convertir DTOs a modelo de dominio (Criadero)
 * Sigue separación de responsabilidades (DTO → Modelo)
 */
public class PersonalyRolesMapper {

    public static PersonalyRoles toPersonalyRolesCreate(CreatePersonalyRolesRequest request) {
        PersonalyRoles personalyRoles = new PersonalyRoles();
             //id auto incrementable
            personalyRoles.setIdPersonal(request.idPersonal());
            personalyRoles.setRut(request.rut());
            personalyRoles.setDv(request.dv());
            personalyRoles.setEspecialidad(request.especialidad());
            personalyRoles.setPrimerNombre(request.primerNombre());
            personalyRoles.setSegundoNombre(request.segundoNombre());
            personalyRoles.setApellidoPaterno(request.apellidoPaterno());
            personalyRoles.setApellidoMaterno(request.apellidoMaterno());
            personalyRoles.setTelefono(request.telefono());
            personalyRoles.setCorreo(request.correo());
            personalyRoles.setDireccion(request.direccion());
            return personalyRoles;
         
    }

    public static PersonalyRoles toPersonalyRolesUpdate( int id, UpdatePersonalyRolesRequest request) {
        PersonalyRoles personalyRoles = new PersonalyRoles();
            //id real desde el endpoint
            personalyRoles.setIdPersonal(request.idPersonal());
            personalyRoles.setRut(request.rut());
            personalyRoles.setDv(request.dv());
            personalyRoles.setEspecialidad(request.especialidad());
            personalyRoles.setPrimerNombre(request.primerNombre());
            personalyRoles.setSegundoNombre(request.segundoNombre());
            personalyRoles.setApellidoPaterno(request.apellidoPaterno());
            personalyRoles.setApellidoMaterno(request.apellidoMaterno());
            personalyRoles.setTelefono(request.telefono());
            personalyRoles.setCorreo(request.correo());
            personalyRoles.setDireccion(request.direccion());
            return personalyRoles;
         
    }
}
