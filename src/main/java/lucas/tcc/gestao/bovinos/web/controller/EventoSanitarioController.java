package lucas.tcc.gestao.bovinos.web.controller;

import jakarta.validation.Valid;
import lucas.tcc.gestao.bovinos.domain.entity.EventoSanitario;
import lucas.tcc.gestao.bovinos.service.EventoSanitarioService;
import lucas.tcc.gestao.bovinos.web.dto.evento.EventoRequest;
import lucas.tcc.gestao.bovinos.web.dto.evento.EventoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos-sanitarios")
public class EventoSanitarioController {
    private final EventoSanitarioService service;

    public EventoSanitarioController(EventoSanitarioService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventoResponse criar(@Valid @RequestBody EventoRequest req){
        EventoSanitario e = service.criar(EventoSanitario.builder()
                .tipo(req.tipo())
                .descricao(req.descricao())
                .dataEvento(req.dataEvento())
                .build(), req.bovinoId());
        return new EventoResponse(e.getId(), e.getBovino().getId(), e.getTipo(), e.getDescricao(), e.getDataEvento());
    }

    @GetMapping
    public List<EventoResponse> listar(){
        return service.listar().stream()
                .map(e -> new EventoResponse(e.getId(), e.getBovino().getId(), e.getTipo(), e.getDescricao(), e.getDataEvento()))
                .toList();
    }

    @GetMapping("/bovino/{bovinoId}")
    public List<EventoResponse> listarPorBovino(@PathVariable Long bovinoId){
        return service.listarPorBovino(bovinoId).stream()
                .map(e -> new EventoResponse(e.getId(), e.getBovino().getId(), e.getTipo(), e.getDescricao(), e.getDataEvento()))
                .toList();
    }
}
