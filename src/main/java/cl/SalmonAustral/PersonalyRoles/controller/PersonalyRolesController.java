package cl.SalmonAustral.PersonalyRoles.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
//DTO
import cl.SalmonAustral.PersonalyRoles.dto.CreatePersonalyRolesRequest;
import cl.SalmonAustral.PersonalyRoles.dto.UpdatePersonalyRolesRequest;
/*EXEPTION
import com.example.bibliotecaduoc.exception.ResourceNotFoundException;*/
//MAPPER
import cl.SalmonAustral.PersonalyRoles.mapper.PersonalyRolesMapper;


import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;
import cl.SalmonAustral.PersonalyRoles.services.PersonalyRolesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/PersonalyRoles")
public class PersonalyRolesController {

        private  PersonalyRolesServices personalyRolesServices;

        public PersonalyRolesController(PersonalyRolesServices personalyRolesServices) {
                this.personalyRolesServices = personalyRolesServices;
        }
        
        @GetMapping
        public List<PersonalyRoles> getPersonalyRoles() {
                return this.personalyRolesServices.getAllPersonalyRoles();
        }
        //pasa del model al dto luego al mapper y termina siendo subido a la base de datos
        //en teoria es para Crear los datos
        @PostMapping
        public PersonalyRoles setPersonalyRolesCreate(@RequestBody CreatePersonalyRolesRequest createPersonal) {
                PersonalyRoles personalyRoles = PersonalyRolesMapper.toPersonalyRolesCreate(createPersonal);
                personalyRoles.getId();
                personalyRoles.getIdPersonal();
                personalyRoles.getRut();
                personalyRoles.getDv();
                personalyRoles.getEspecialidad();
                personalyRoles.getPrimerNombre();
                personalyRoles.getSegundoNombre();
                personalyRoles.getApellidoPaterno();
                personalyRoles.getApellidoMaterno();
                personalyRoles.getTelefono();
                personalyRoles.getCorreo();
                personalyRoles.getDireccion();
                this.personalyRolesServices.setIdPersonal(personalyRoles);
                return personalyRoles;
        }
        /*pasa del model -> dto -> mapper -> controller termina siendo subido a la base de datos. es para Actualizar los datos. 
        al ser un metodo que actualiza necesita si o si el dato identificador(id en este caso) y dentro del argumento, debiamos llamar al @PathVariable(id)*/
        @PutMapping("/{id}")
        public PersonalyRoles updatePersonalyRolesUpdate(
                @PathVariable("id") int id,
                @RequestBody UpdatePersonalyRolesRequest UpdatePersonal) {
                PersonalyRoles personalyRoles = PersonalyRolesMapper.toPersonalyRolesUpdate(id, UpdatePersonal); //Argumentamos con los dos valores importantes
                personalyRoles.getId();
                personalyRoles.getIdPersonal();
                personalyRoles.getRut();
                personalyRoles.getDv();
                personalyRoles.getEspecialidad();
                personalyRoles.getPrimerNombre();
                personalyRoles.getSegundoNombre();
                personalyRoles.getApellidoPaterno();
                personalyRoles.getApellidoMaterno();
                personalyRoles.getTelefono();
                personalyRoles.getCorreo();
                personalyRoles.getDireccion();
                this.personalyRolesServices.setIdPersonal(personalyRoles);
                return personalyRoles;
        }
        //System.err.println(); Sirve solo para debuggear

}
