package cl.SalmonAustral.PersonalyRoles.repository;

import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PersonalyRolesRepository extends JpaRepository<PersonalyRoles, Integer> {

    /*  Consulta nativa simple ejemplo
    @Query(value = "SELECT * FROM libros WHERE editorial = :editorial", nativeQuery = true)
    List<Libro> selectPorEditorial(@Param("editorial") String editorial);
    */
    List<PersonalyRoles> findByIdPersonal(String idPersonal);

    // Consulta nativa simple
    @Query(value = "SELECT * FROM personalyRoles WHERE especialidad = :especialidad", nativeQuery = true)
    List<PersonalyRoles> mostrarEspecialidad(@Param("especialidad") String especialidad);

}
