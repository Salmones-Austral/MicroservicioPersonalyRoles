package cl.SalmonAustral.PersonalyRoles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;
import cl.SalmonAustral.PersonalyRoles.repository.PersonalyRolesRepository;

@Service
public class PersonalyRolesServices {
    @Autowired
    private PersonalyRolesRepository personalRepo;

    //Retornar todo
    public List<PersonalyRoles> getAllPersonalyRoles(){
        return personalRepo.findAll();
    }
    //retornar por id o nulo
    public PersonalyRoles getIdPersonal(Integer idPersonal){
        return personalRepo.findById(idPersonal).orElse(null);
    }
    //guardar
    public void setIdPersonal(PersonalyRoles personalyRoles){
        personalRepo.save(personalyRoles);
    }
    //###//
    //borrar por id
    public Integer borrarIdPersonal(Integer idPersonal){
        personalRepo.deleteById(idPersonal);
        return idPersonal;
    }
    //filtrar por especialidad
    public List<PersonalyRoles> getEspecialidad(String especialidad){
        return personalRepo.findByEspecialidad(especialidad);
    }
}
