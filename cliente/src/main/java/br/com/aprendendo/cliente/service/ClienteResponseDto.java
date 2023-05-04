package br.com.aprendendo.cliente.service;

import br.com.aprendendo.cliente.model.entity.Cliente;

public record ClienteResponseDto(Long id, String nome, String email, String cpf) {

    public ClienteResponseDto(Cliente cliente){
        this(cliente.getId(), cliente.getNome(),cliente.getEmail(),cliente.getCpf());
    }

}
