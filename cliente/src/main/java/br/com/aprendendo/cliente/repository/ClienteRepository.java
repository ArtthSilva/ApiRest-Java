package br.com.aprendendo.cliente.repository;

import br.com.aprendendo.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}