package entrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entrega.model.Aposta;
import entrega.service.ApostaService;

@RestController
@RequestMapping("/apostas")
public class ApostaController {
    @Autowired
    private ApostaService apostaService;

    @GetMapping
    public List<Aposta> listarTodos() {
        return apostaService.listarTodos();
    }

    @PostMapping
    public Aposta criar(@RequestBody Aposta aposta) {
        return apostaService.criar(aposta);
    }
}
