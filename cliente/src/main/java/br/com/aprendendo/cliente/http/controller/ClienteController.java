package br.com.aprendendo.cliente.http.controller;

import br.com.aprendendo.cliente.model.entity.Cliente;
import br.com.aprendendo.cliente.repository.ClienteRepository;
import br.com.aprendendo.cliente.service.ClienteRequestDto;
import br.com.aprendendo.cliente.service.ClienteResponseDto;
import br.com.aprendendo.cliente.service.ClienteService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody ClienteRequestDto cliente){
        Cliente clientedata = new Cliente(cliente);
        return clienteService.salvar(clientedata);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteResponseDto> listaCliente(Pageable paginacao){
        return clienteService.listaCliente(paginacao);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePorId(@PathVariable("id") Long id){
        return clienteService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void removerCliente(@PathVariable Long id) {
         clienteRepository.deleteById(id);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void atualizarCliente(@RequestBody ClienteRequestDto dados){
            var cliente = clienteRepository.getReferenceById(dados.id());
            cliente.atualizarInformacoes(dados);
                }
    }