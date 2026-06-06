package cl.SalmonAustral.PersonalyRoles.repository;

import cl.SalmonAustral.PersonalyRoles.model.PersonalyRoles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalyRolesRepository extends JpaRepository<PersonalyRoles, Integer> {
    List<PersonalyRoles> findByEspecialidad(String especialidad);

}
