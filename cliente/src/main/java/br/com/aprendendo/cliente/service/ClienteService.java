package br.com.aprendendo.cliente.service;

import br.com.aprendendo.cliente.entity.Cliente;
import br.com.aprendendo.cliente.model.ClienteDto;
import br.com.aprendendo.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Page<ClienteDto> listaCliente(Pageable paginacao){
        return clienteRepository.findAll(paginacao).map(ClienteDto::new);
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public void removerPorId(Long id){
        clienteRepository.deleteById(id);
    }
}