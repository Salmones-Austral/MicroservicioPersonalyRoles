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
/*DTO
import com.example.bibliotecaduoc.dto.CreateLibroRequest;
import com.example.bibliotecaduoc.dto.UpdateLibroRequest;*/
/*EXEPTION
import com.example.bibliotecaduoc.exception.ResourceNotFoundException;*/
/*MAPPER
import com.example.bibliotecaduoc.mapper.LibroMapper;*/

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

        @PostMapping
        public PersonalyRoles setPersonalyRoles(@RequestBody PersonalyRoles personalyRoles) {
            this.personalyRolesServices.setIdPersonal(personalyRoles);
            return personalyRoles;
        }
        

        @GetMapping("{id}")
        public ResponseEntity<Libro> buscarLibro(@PathVariable int id) {
                Libro libro = libroService.getLibroId(id);

                if (libro == null) {

                        throw new ResourceNotFoundException("Libro no encontrado para id: " + id);
                }

                return ResponseEntity.ok(libro);
        }

        @PutMapping("{id}")
        public ResponseEntity<Libro> actualizarLibro(@PathVariable int id,
                        @Valid @RequestBody UpdateLibroRequest request) {
                // El ID viene del path, no del body → evita ambigüedad
                Libro libroActualizado = libroService.updateLibro(LibroMapper.toModel(id, request));
                return ResponseEntity.ok(libroActualizado);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
                libroService.deleteLibro(id);
                return ResponseEntity.noContent().build(); // 204 No Content (estándar REST)
        }

        @GetMapping("/total")
        public ResponseEntity<Integer> totalLibros() {
                int total = libroService.totalLibrosV2();
                return ResponseEntity.ok(total);
        }

        @GetMapping("/editorial/{editorial}")
        public List<Libro> getporEditorial(@PathVariable String editorial) {
                return libroService.obtenerPorEditorial(editorial);
        }

        @GetMapping("/editorial")
        public List<Libro> getporEditorial2(@RequestParam String editorial) {
                return libroService.obtenerPorEditorial(editorial);
        }

}
