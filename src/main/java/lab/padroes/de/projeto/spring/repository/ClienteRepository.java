package lab.padroes.de.projeto.spring.repository;

import lab.padroes.de.projeto.spring.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
