package lucas.tcc.gestao.bovinos.web.controller;

import jakarta.validation.Valid;
import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.service.BovinoService;
import lucas.tcc.gestao.bovinos.web.dto.bovino.BovinoRequest;
import lucas.tcc.gestao.bovinos.web.dto.bovino.BovinoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bovinos")
public class BovinoController {
    private final BovinoService service;

    public BovinoController(BovinoService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BovinoResponse criar(@Valid @RequestBody BovinoRequest req){
        Bovino b = service.criar(Bovino.builder()
                .nomeAnimal(req.nomeAnimal())
                .codigoEpc(req.codigoEpc())
                .codigoInterno(req.codigoInterno())
                .numeroBrinco(req.numeroBrinco())
                .raca(req.raca())
                .dataNascimento(req.dataNascimento())
                .pesoAtualKg(req.pesoAtualKg())
                .pelagem(req.pelagem())
                .build(), req.invernadaId());

        return new BovinoResponse(b.getId(), b.getNomeAnimal(), b.getCodigoEpc(), b.getCodigoInterno(),
                b.getNumeroBrinco(), b.getRaca(), b.getDataNascimento(), b.getPesoAtualKg(), b.getPelagem(),
                b.getInvernada().getId(), b.getInvernada().getDescricao());
    }

    @GetMapping
    public List<BovinoResponse> listar(){
        return service.listar().stream().map(b ->
                new BovinoResponse(b.getId(), b.getNomeAnimal(), b.getCodigoEpc(), b.getCodigoInterno(),
                        b.getNumeroBrinco(), b.getRaca(), b.getDataNascimento(), b.getPesoAtualKg(), b.getPelagem(),
                        b.getInvernada().getId(), b.getInvernada().getDescricao())
        ).toList();
    }

    @GetMapping("/{id}")
    public BovinoResponse buscar(@PathVariable Long id){
        Bovino b = service.buscar(id);
        return new BovinoResponse(b.getId(), b.getNomeAnimal(), b.getCodigoEpc(), b.getCodigoInterno(),
                b.getNumeroBrinco(), b.getRaca(), b.getDataNascimento(), b.getPesoAtualKg(), b.getPelagem(),
                b.getInvernada().getId(), b.getInvernada().getDescricao());
    }

    @PutMapping("/{id}")
    public BovinoResponse atualizar(@PathVariable Long id, @Valid @RequestBody BovinoRequest req){
        Bovino b = service.atualizar(id, Bovino.builder()
                .nomeAnimal(req.nomeAnimal())
                .codigoEpc(req.codigoEpc())
                .codigoInterno(req.codigoInterno())
                .numeroBrinco(req.numeroBrinco())
                .raca(req.raca())
                .dataNascimento(req.dataNascimento())
                .pesoAtualKg(req.pesoAtualKg())
                .pelagem(req.pelagem())
                .build(), req.invernadaId());

        return new BovinoResponse(b.getId(), b.getNomeAnimal(), b.getCodigoEpc(), b.getCodigoInterno(),
                b.getNumeroBrinco(), b.getRaca(), b.getDataNascimento(), b.getPesoAtualKg(), b.getPelagem(),
                b.getInvernada().getId(), b.getInvernada().getDescricao());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){ service.deletar(id); }

    @GetMapping("/invernada/{invernadaId}")
    public List<BovinoResponse> listarPorInvernada(@PathVariable Long invernadaId){
        return service.listarPorInvernada(invernadaId).stream().map(b ->
                new BovinoResponse(b.getId(), b.getNomeAnimal(), b.getCodigoEpc(), b.getCodigoInterno(),
                        b.getNumeroBrinco(), b.getRaca(), b.getDataNascimento(), b.getPesoAtualKg(), b.getPelagem(),
                        b.getInvernada().getId(), b.getInvernada().getDescricao())
        ).toList();
    }
}
