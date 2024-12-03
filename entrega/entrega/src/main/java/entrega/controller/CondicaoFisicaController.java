package entrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entrega.model.CondicaoFisica;
import entrega.service.CondicaoFisicaService;

@RestController
@RequestMapping("/condicoes")
public class CondicaoFisicaController {
    @Autowired
    private CondicaoFisicaService condicaoFisicaService;

    @GetMapping
    public List<CondicaoFisica> listarTodos() {
        return condicaoFisicaService.listarTodos();
    }

    @PostMapping
    public CondicaoFisica criar(@RequestBody CondicaoFisica condicao) {
        return condicaoFisicaService.criar(condicao);
    }
}
