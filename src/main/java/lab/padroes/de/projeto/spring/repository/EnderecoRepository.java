package lab.padroes.de.projeto.spring.repository;

import lab.padroes.de.projeto.spring.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
