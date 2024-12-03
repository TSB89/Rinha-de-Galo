package entrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entrega.model.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {
}
