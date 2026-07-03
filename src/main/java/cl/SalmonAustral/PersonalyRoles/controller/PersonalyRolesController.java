package cl.SalmonAustral.PersonalyRoles.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList; // <-- IMPORTANTE: Agregado para la lista temporal de alertas

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cl.SalmonAustral.PersonalyRoles.dto.*;
import cl.SalmonAustral.PersonalyRoles.mapper.PersonalyRolesMapper;
import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;
import cl.SalmonAustral.PersonalyRoles.services.PersonalyRolesServices;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/personalyRoles")
public class PersonalyRolesController {

        private final PersonalyRolesServices personalyRolesSer;

        // Lista en memoria para guardar las alertas que lleguen desde el microservicio de Alertas
        private final List<Map<String, Object>> buzonAlertasVeterinario = new ArrayList<>();

        public PersonalyRolesController(PersonalyRolesServices personalyRolesSer) {
                this.personalyRolesSer = personalyRolesSer;
        }
        //todo
        @GetMapping
        public ResponseEntity<List<PersonalyRoles>> listarPersonal() {
                return ResponseEntity.ok(personalyRolesSer.getAllPersonalyRoles());
        }
        //eliminar
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePersonal(@PathVariable Integer id) {
                personalyRolesSer.deleteIdPersonalyRoles(id);
                return ResponseEntity.noContent().build();
        }
        //filtrar por id
        @GetMapping("/{id}")
        public ResponseEntity<PersonalyRoles> obtenerPersonalPorId(@PathVariable Integer id) {
                PersonalyRoles personal = personalyRolesSer.getIdPersonalyRoles(id);
                return ResponseEntity.ok(personal);        
        }
        //Crear
        @PostMapping
        public ResponseEntity<?> crearPersonal(@Valid @RequestBody CreatePersonalyRolesRequest createPersonal, BindingResult result) {
                if (result.hasErrors()) {
                Map<String, String> errores = new HashMap<>();
                result.getFieldErrors().forEach(error -> 
                        errores.put(error.getField(), error.getDefaultMessage())
                );
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
                }
                PersonalyRoles personal = PersonalyRolesMapper.toPersonalyRolesCreate(createPersonal);
                PersonalyRoles guardar = personalyRolesSer.setPersonalyRoles(personal);
                return ResponseEntity.status(HttpStatus.CREATED).body(guardar);
        }
        //Actualizar
        @PutMapping("/{id}")
        public ResponseEntity<?> actualizarPersonal(
                @PathVariable Integer id,
                @Valid @RequestBody UpdatePersonalyRolesRequest updatePersonal, BindingResult result) {
                if (result.hasErrors()) {
                Map<String, String> errores = new HashMap<>();
                result.getFieldErrors().forEach(error -> 
                        errores.put(error.getField(), error.getDefaultMessage())
                );
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
                }
                PersonalyRoles personal = PersonalyRolesMapper.toPersonalyRolesUpdate(id, updatePersonal);
                PersonalyRoles actualizado = personalyRolesSer.updatePersonalyRoles(personal);

                return ResponseEntity.ok(actualizado);
        }
        ////////////Metodos custom///////////////
        @GetMapping("/filtrar")
        public ResponseEntity<List<PersonalyRoles>> getPersonalPorEspecialidad(@RequestParam String especialidad) {
                List<PersonalyRoles> resultados = personalyRolesSer.filtrarPorEspecialidad(especialidad);
                if (resultados.isEmpty()) {
                return ResponseEntity.noContent().build();
                }
                return ResponseEntity.ok(resultados);
        }
        @PostMapping("/login")
        public ResponseEntity<?> inicioSesion(@RequestBody LoginRequest loginRequest) {
                boolean exito = personalyRolesSer.login(loginRequest.getRut(), loginRequest.getDv(), loginRequest.getPrimerNombre());
                if (exito) {
                        Map<String, String> respuesta = new HashMap<>();
                        respuesta.put("mensaje", "Inicio de sesión exitoso. Bienvenido " + loginRequest.getPrimerNombre());
                        return ResponseEntity.ok(respuesta);
                } else {
                        Map<String, String> error = new HashMap<>();
                        error.put("error", "Error al inicio de sesion. El RUT, el DIGITO VERIFICADOR o el NOMBRE no coinciden.");
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
                }
        }
        
        // =================================================================================
        // NUEVOS MÉTODOS PARA RECIBIR LA ALERTA ASÍNCRONA DE MORTALIDAD (HISTORIA JORGE)
        // =================================================================================
        
        // 1. EL ENDPOINT POST: El microservicio de Alertas llamará aquí en segundo plano
        @PostMapping("/notificar")
        public ResponseEntity<Void> recibirAlertaVeterinario(@RequestBody Map<String, Object> payload) {
                System.out.println("🚨 [ALERTA RECIBIDA EN PUERTO MONTT] Notificando al veterinario: " + payload);
                
                // Guardamos el mensaje en nuestra lista temporal
                buzonAlertasVeterinario.add(payload);
                
                return ResponseEntity.ok().build();
        }

        // 2. EL ENDPOINT GET: en Postman para verificar que el mensaje llegó
        @GetMapping("/ver-alertas")
        public ResponseEntity<List<Map<String, Object>>> revisarBuzonAlertas() {
                return ResponseEntity.ok(buzonAlertasVeterinario);
        }
}