package cl.SalmonAustral.PersonalyRoles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;
import cl.SalmonAustral.PersonalyRoles.repository.PersonalyRolesRepository;
import cl.SalmonAustral.PersonalyRoles.exceptions.ResourceNotFoundException;

@Service
public class PersonalyRolesServices {
    @Autowired    
    private PersonalyRolesRepository PersonalRepo;
    //todo
    public List<PersonalyRoles> getAllPersonalyRoles() {
        return PersonalRepo.findAll();
    }
    //obtener id
    public PersonalyRoles getIdPersonalyRoles(int id) {
        return PersonalRepo.findById(id).orElse(null);
    }
    //guardar
    public PersonalyRoles setPersonalyRoles(PersonalyRoles personalyRoles) {
        return PersonalRepo.save(personalyRoles);
    }
    //actualizar
    public PersonalyRoles updatePersonalyRoles(PersonalyRoles personalyRoles) {
        if (!PersonalRepo.existsById(personalyRoles.getId())) {
            throw new ResourceNotFoundException("Alimentacion no existe con id: " + personalyRoles.getId());
        }
        return PersonalRepo.save(personalyRoles);
    }
    //eliminar
    public void deleteIdPersonalyRoles(int id) {
        PersonalRepo.deleteById(id);
    }
    //filtrar especialidad
    public List<PersonalyRoles> filtrarPorEspecialidad(String especialidad) {
        return PersonalRepo.findByEspecialidad(especialidad);
    }
}
