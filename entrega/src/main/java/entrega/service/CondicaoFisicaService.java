package entrega.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrega.model.CondicaoFisica;
import entrega.repository.CondicaoFisicaRepository;

@Service
public class CondicaoFisicaService {
    @Autowired
    private CondicaoFisicaRepository condicaoFisicaRepository;

    public List<CondicaoFisica> listarTodos() {
        return condicaoFisicaRepository.findAll();
    }

    public CondicaoFisica criar(CondicaoFisica condicaoFisica) {
        return condicaoFisicaRepository.save(condicaoFisica);
    }

    public Optional<CondicaoFisica> buscarPorId(Long id) {
        return condicaoFisicaRepository.findById(id);
    }

    public CondicaoFisica atualizar(Long id, CondicaoFisica condicaoAtualizada) {
        Optional<CondicaoFisica> condicaoExistente = condicaoFisicaRepository.findById(id);
        if (condicaoExistente.isPresent()) {
            CondicaoFisica condicao = condicaoExistente.get();
            condicao.setDescricao(condicaoAtualizada.getDescricao());
            return condicaoFisicaRepository.save(condicao);
        }
        throw new RuntimeException("Condição física não encontrada.");
    }

    public void deletar(Long id) {
        if (condicaoFisicaRepository.existsById(id)) {
            condicaoFisicaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Condição física não encontrada.");
        }
    }
}
