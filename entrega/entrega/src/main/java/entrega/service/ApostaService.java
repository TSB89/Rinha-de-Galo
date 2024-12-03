package entrega.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrega.model.Aposta;
import entrega.repository.ApostaRepository;

@Service
public class ApostaService {
    @Autowired
    private ApostaRepository apostaRepository;

    public List<Aposta> listarTodos() {
        return apostaRepository.findAll();
    }

    public Aposta criar(Aposta aposta) {
        return apostaRepository.save(aposta);
    }

    public Optional<Aposta> buscarPorId(Long id) {
        return apostaRepository.findById(id);
    }

    public Aposta atualizar(Long id, Aposta apostaAtualizada) {
        Optional<Aposta> apostaExistente = apostaRepository.findById(id);
        if (apostaExistente.isPresent()) {
            Aposta aposta = apostaExistente.get();
            aposta.setValor(apostaAtualizada.getValor());
            aposta.setCliente(apostaAtualizada.getCliente());
            aposta.setGalo(apostaAtualizada.getGalo());
            return apostaRepository.save(aposta);
        }
        throw new RuntimeException("Aposta não encontrada.");
    }

    public void deletar(Long id) {
        if (apostaRepository.existsById(id)) {
            apostaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Aposta não encontrada.");
        }
    }
}
