package entrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entrega.model.Galo;
import entrega.service.GaloService;

@RestController
@RequestMapping("/galos")
public class GaloController {
    @Autowired
    private GaloService galoService;

    @GetMapping
    public List<Galo> listarTodos() {
        return galoService.listarTodos();
    }

    @PostMapping
    public Galo criar(@RequestBody Galo galo) {
        return galoService.criar(galo);
    }
}
