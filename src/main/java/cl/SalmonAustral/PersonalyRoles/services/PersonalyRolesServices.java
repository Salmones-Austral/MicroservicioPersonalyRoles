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
    private PersonalyRolesRepository personalRepo;
    //todo
    public List<PersonalyRoles> getAllPersonalyRoles() {
        return personalRepo.findAll();
    }
    //obtener id
    public PersonalyRoles getIdPersonalyRoles(int id) {
        return personalRepo.findById(id).
        orElseThrow(() -> new ResourceNotFoundException("El personal no existe con id: " + id));
    }
    //guardar
    public PersonalyRoles setPersonalyRoles(PersonalyRoles personalyRoles) {
        return personalRepo.save(personalyRoles);
    }
    //actualizar
    public PersonalyRoles updatePersonalyRoles(PersonalyRoles personalyRoles) {
        if (!personalRepo.existsById(personalyRoles.getId())) {
            throw new ResourceNotFoundException("El personal no existe con id: " + personalyRoles.getId());
        }
        return personalRepo.save(personalyRoles);
    }
    //eliminar
    public void deleteIdPersonalyRoles(int id) {
        if(!personalRepo.existsById(id)){
            throw new ResourceNotFoundException("El personal no existe con id: " + id);
        }
        personalRepo.deleteById(id);
    }
    //filtrar especialidad
    public List<PersonalyRoles> filtrarPorEspecialidad(String especialidad) {
        return personalRepo.findByEspecialidad(especialidad);
    }
}
