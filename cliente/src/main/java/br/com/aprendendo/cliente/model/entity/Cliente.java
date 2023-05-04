package br.com.aprendendo.cliente.model.entity;

import br.com.aprendendo.cliente.service.ClienteRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    public Cliente(ClienteRequestDto data){
        this.nome = data.nome();
        this.email = data.email();
        this.cpf = data.cpf();
    }

    public void atualizarInformacoes(ClienteRequestDto dados){
        if (dados != null){
            this.nome = dados.nome();
        }

        if (dados != null){
            this.email = dados.email();
        }
        if (dados != null){
            this.cpf = dados.cpf();
        }

    }

}