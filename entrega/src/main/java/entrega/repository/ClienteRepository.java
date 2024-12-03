package entrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entrega.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
