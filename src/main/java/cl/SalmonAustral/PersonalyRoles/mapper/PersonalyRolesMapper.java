package cl.SalmonAustral.PersonalyRoles.mapper;

import cl.SalmonAustral.PersonalyRoles.dto.CreatePersonalyRolesRequest;
import cl.SalmonAustral.PersonalyRoles.dto.UpdatePersonalyRolesRequest;
import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;

/**
 * Mapper para convertir DTOs a modelo de dominio (Criadero)
 * Sigue separación de responsabilidades (DTO → Modelo)
 */
public class PersonalyRolesMapper {

    public static PersonalyRoles toModel(CreatePersonalyRolesRequest request) {
        return new PersonalyRoles(
            0, //id auto incrementable
            request.idPersonal(),
            request.rut(),
            request.dv(),
            request.especialidad(),
            request.primerNombre(),
            request.segundoNombre(),
            request.apellidoPaterno(),
            request.apellidoMaterno(),
            request.telefono(),
            request.correo(),
            request.direccion()
        ); 
    }

    public static PersonalyRoles toModel( int id, UpdatePersonalyRolesRequest request) {
        return new PersonalyRoles(
            id, //id real desde el endpoint
            request.idPersonal(),
            request.rut(),
            request.dv(),
            request.especialidad(),
            request.primerNombre(),
            request.segundoNombre(),
            request.apellidoPaterno(),
            request.apellidoMaterno(),
            request.telefono(),
            request.correo(),
            request.direccion()
        ); 
    }
}
