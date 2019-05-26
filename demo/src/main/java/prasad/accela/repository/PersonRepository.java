package prasad.accela.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import prasad.accela.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	List<Person> findAllById(Integer id);
}
