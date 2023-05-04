package br.com.aprendendo.cliente.service;

import br.com.aprendendo.cliente.model.entity.Cliente;
import br.com.aprendendo.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Page<ClienteResponseDto> listaCliente(Pageable paginacao){
        return clienteRepository.findAll(paginacao).map(ClienteResponseDto::new);
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public void removerPorId(Long id){
        clienteRepository.deleteById(id);
    }
}