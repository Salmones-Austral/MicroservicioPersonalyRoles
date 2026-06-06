package cl.SalmonAustral.PersonalyRoles.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
//DTO
import cl.SalmonAustral.PersonalyRoles.dto.*;

//MAPPER
import cl.SalmonAustral.PersonalyRoles.mapper.PersonalyRolesMapper;


import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;
import cl.SalmonAustral.PersonalyRoles.services.PersonalyRolesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/PersonalyRoles")
public class PersonalyRolesController {
        private  PersonalyRolesServices personalyRolesSer;
        private final WebClient webClient;
        @Autowired
        public PersonalyRolesController(PersonalyRolesServices personalyRolesSer, WebClient.Builder webClientBuilder) {
                this.personalyRolesSer = personalyRolesSer;
                this.webClient = webClientBuilder.build(); 
        }
        //todo
        @GetMapping
        public ResponseEntity<List<PersonalyRoles>> listarCriaderos() {
                return ResponseEntity.ok(personalyRolesSer.getAllPersonalyRoles());
        }
        //eliminar
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteAlimentacion(@PathVariable Integer id) {
                personalyRolesSer.deleteIdPersonalyRoles(id);
                return ResponseEntity.noContent().build();
        }
        //crear
        @PostMapping
        public ResponseEntity<?> crearAlimentacion(@Valid @RequestBody CreatePersonalyRolesRequest CreatePersonal, BindingResult result) {
                
                if (result.hasErrors()) {
                Map<String, String> errores = new HashMap<>();
                result.getFieldErrors().forEach(error -> 
                        errores.put(error.getField(), error.getDefaultMessage())
                );
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
                }
                PersonalyRoles personal = PersonalyRolesMapper.toPersonalyRolesCreate(CreatePersonal);
                PersonalyRoles guardar = personalyRolesSer.setPersonalyRoles(personal);
                
                return ResponseEntity.status(HttpStatus.CREATED).body(guardar);
        }
        //actualizar
         @PutMapping("/{id}")
        public ResponseEntity<?> actualizarCriadero(
                @PathVariable Integer id,
                @Valid @RequestBody UpdatePersonalyRolesRequest updatePersonal, BindingResult result) {

                if (result.hasErrors()) {
                Map<String, String> errores = new HashMap<>();
                result.getFieldErrors().forEach(error -> 
                        errores.put(error.getField(), error.getDefaultMessage())
                );
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
                }

                // MAGIA DEL MAPPER: Convierte el DTO validado al modelo de la BD
                PersonalyRoles personal = PersonalyRolesMapper.toPersonalyRolesUpdate(id, updatePersonal);
                PersonalyRoles actualizado = personalyRolesSer.updatePersonalyRoles(personal);

                return ResponseEntity.ok(actualizado);
        }
        //filtrar por especialidad
        @GetMapping("/filtrar")
        public ResponseEntity<List<PersonalyRoles>> getPersonalPorEspecialidad(
                @RequestParam String especialidad) {
                List<PersonalyRoles> resultados = personalyRolesSer.filtrarPorEspecialidad(especialidad);
                if (resultados.isEmpty()) {
                return ResponseEntity.noContent().build();
                }
                return ResponseEntity.ok(resultados);
        }
}
