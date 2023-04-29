package br.com.aprendendo.cliente.model;

import br.com.aprendendo.cliente.entity.Cliente;

public record ClienteDto(String nome, String email, String cpf) {

    public ClienteDto(Cliente cliente){
        this(cliente.getNome(),cliente.getEmail(),cliente.getCpf());
    }

}
