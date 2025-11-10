package lucas.tcc.gestao.bovinos.service;

import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.domain.entity.Invernada;
import lucas.tcc.gestao.bovinos.domain.repository.BovinoRepository;
import lucas.tcc.gestao.bovinos.web.error.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BovinoService {
    private final BovinoRepository repo;
    private final InvernadaService invernadaService;

    public BovinoService(BovinoRepository repo, InvernadaService invernadaService) {
        this.repo = repo;
        this.invernadaService = invernadaService;
    }

    public Bovino criar(Bovino b, Long invernadaId){
        Invernada inv = invernadaService.buscar(invernadaId);
        b.setInvernada(inv);
        return repo.save(b);
    }

    public List<Bovino> listar(){ return repo.findAll(); }
    public Bovino buscar(Long id){
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Bovino não encontrado"));
    }
    public Bovino atualizar(Long id, Bovino changes, Long invernadaId){
        Bovino b = buscar(id);
        if(invernadaId != null){
            b.setInvernada(invernadaService.buscar(invernadaId));
        }
        b.setNomeAnimal(changes.getNomeAnimal());
        b.setCodigoEpc(changes.getCodigoEpc());
        b.setCodigoInterno(changes.getCodigoInterno());
        b.setNumeroBrinco(changes.getNumeroBrinco());
        b.setRaca(changes.getRaca());
        b.setDataNascimento(changes.getDataNascimento());
        b.setPelagem(changes.getPelagem());
        b.setPesoAtualKg(changes.getPesoAtualKg());
        return repo.save(b);
    }
    public void deletar(Long id){ repo.deleteById(id); }
    public List<Bovino> listarPorInvernada(Long invernadaId){
        return repo.findByInvernada(invernadaService.buscar(invernadaId));
    }
}
