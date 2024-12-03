package entrega.service;

import entrega.model.Galo;
import entrega.repository.GaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GaloService {
    @Autowired
    private GaloRepository galoRepository;

    // Listar todos os galos
    public List<Galo> listarTodos() {
        return galoRepository.findAll();
    }

    // Criar um novo galo
    public Galo criar(Galo galo) {
        return galoRepository.save(galo);
    }

    // Buscar um galo pelo ID
    public Optional<Galo> buscarPorId(Long id) {
        return galoRepository.findById(id);
    }

    // Atualizar um galo existente
    public Galo atualizar(Long id, Galo galoAtualizado) {
        Optional<Galo> galoExistente = galoRepository.findById(id);
        if (galoExistente.isPresent()) {
            Galo galo = galoExistente.get();
            galo.setNome(galoAtualizado.getNome());
            galo.setIdade(galoAtualizado.getIdade());
            galo.setPeso(galoAtualizado.getPeso());
            return galoRepository.save(galo);
        }
        throw new RuntimeException("Galo não encontrado.");
    }

    // Deletar um galo
    public void deletar(Long id) {
        if (galoRepository.existsById(id)) {
            galoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Galo não encontrado.");
        }
    }
}
