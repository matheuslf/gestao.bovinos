package lucas.tcc.gestao.bovinos.web.controller;

import jakarta.validation.Valid;
import lucas.tcc.gestao.bovinos.domain.entity.Invernada;
import lucas.tcc.gestao.bovinos.service.InvernadaService;
import lucas.tcc.gestao.bovinos.web.dto.invernada.InvernadaRequest;
import lucas.tcc.gestao.bovinos.web.dto.invernada.InvernadaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invernadas")
public class InvernadaController {
    private final InvernadaService service;

    public InvernadaController(InvernadaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvernadaResponse criar(@Valid @RequestBody InvernadaRequest req){
        Invernada i = service.criar(Invernada.builder()
                .descricao(req.descricao())
                .urlFoto(req.urlFoto())
                .observacoes(req.observacoes())
                .build());
        return new InvernadaResponse(i.getId(), i.getDescricao(), i.getUrlFoto(), i.getObservacoes());
    }

    @GetMapping
    public List<InvernadaResponse> listar(){
        return service.listar().stream()
                .map(i -> new InvernadaResponse(i.getId(), i.getDescricao(), i.getUrlFoto(), i.getObservacoes()))
                .toList();
    }

    @GetMapping("/{id}")
    public InvernadaResponse buscar(@PathVariable Long id){
        Invernada i = service.buscar(id);
        return new InvernadaResponse(i.getId(), i.getDescricao(), i.getUrlFoto(), i.getObservacoes());
    }

    @PutMapping("/{id}")
    public InvernadaResponse atualizar(@PathVariable Long id, @Valid @RequestBody InvernadaRequest req){
        Invernada i = service.atualizar(id, Invernada.builder()
                .descricao(req.descricao())
                .urlFoto(req.urlFoto())
                .observacoes(req.observacoes())
                .build());
        return new InvernadaResponse(i.getId(), i.getDescricao(), i.getUrlFoto(), i.getObservacoes());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
