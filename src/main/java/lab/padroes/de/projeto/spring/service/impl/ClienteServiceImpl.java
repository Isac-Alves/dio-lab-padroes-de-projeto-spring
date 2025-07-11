package lab.padroes.de.projeto.spring.service.impl;

import lab.padroes.de.projeto.spring.model.Cliente;
import lab.padroes.de.projeto.spring.model.Endereco;
import lab.padroes.de.projeto.spring.repository.ClienteRepository;
import lab.padroes.de.projeto.spring.repository.EnderecoRepository;
import lab.padroes.de.projeto.spring.service.ClienteService;
import lab.padroes.de.projeto.spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            this.salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco; //caso não tenha um endereco ele vai buscar no viacep e salvar
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
