package at.spengergasse.spring_thymeleaf.entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HaustierRepository extends JpaRepository<Haustier,Integer> {

// <a th:href="@{/edit(id=${haustier.id})}">Edit haustier</a>

}
