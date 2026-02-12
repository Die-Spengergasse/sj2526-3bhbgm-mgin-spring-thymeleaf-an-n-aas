package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    // interfac, welche das framework schon bereitstellt, um mit der datenbank zu kommunizieren
    // jpa repository: interface, welches von spring bereitgestellt wird, um mit der datenbank zu kommunizieren
    // patient: entity, mit der wir arbeiten wollen
    // integer: typ des primary keys der entity
    // repository: annotation, mit der wir dem framework sagen, dass es selbst eine instanz dieser klasse erstellen soll,
    // damit wir sie in anderen klassen verwenden können (dependency injection)
}
