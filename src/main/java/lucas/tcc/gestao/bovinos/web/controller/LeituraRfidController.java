package lucas.tcc.gestao.bovinos.web.controller;

import jakarta.validation.Valid;
import lucas.tcc.gestao.bovinos.domain.entity.LeituraRFID;
import lucas.tcc.gestao.bovinos.service.LeituraRfidService;
import lucas.tcc.gestao.bovinos.web.dto.leitura.LeituraRequest;
import lucas.tcc.gestao.bovinos.web.dto.leitura.LeituraResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leitura-rfid")
public class LeituraRfidController {
    private final LeituraRfidService service;

    public LeituraRfidController(LeituraRfidService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeituraResponse criar(@Valid @RequestBody LeituraRequest req){
        LeituraRFID l = service.criar(LeituraRFID.builder()
                .antena(req.antena())
                .timestamp(req.timestamp())
                .build(), req.bovinoId());
        return new LeituraResponse(l.getId(), l.getBovino().getId(), l.getAntena(), l.getTimestamp());
    }

    @GetMapping
    public List<LeituraResponse> listar(){
        return service.listar().stream()
                .map(l -> new LeituraResponse(l.getId(), l.getBovino().getId(), l.getAntena(), l.getTimestamp()))
                .toList();
    }

    @GetMapping("/bovino/{bovinoId}")
    public List<LeituraResponse> listarPorBovino(@PathVariable Long bovinoId){
        return service.listarPorBovino(bovinoId).stream()
                .map(l -> new LeituraResponse(l.getId(), l.getBovino().getId(), l.getAntena(), l.getTimestamp()))
                .toList();
    }

    @GetMapping("/ultimas")
    public List<LeituraResponse> listarUltimas() {
        return service.listarUltimasPorBovino().stream()
                .map(l -> new LeituraResponse(
                        l.getId(),
                        l.getBovino().getId(),
                        l.getAntena(),
                        l.getTimestamp()
                ))
                .toList();
    }
}
