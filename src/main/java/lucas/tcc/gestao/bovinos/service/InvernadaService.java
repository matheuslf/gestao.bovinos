package lucas.tcc.gestao.bovinos.service;

import lucas.tcc.gestao.bovinos.domain.entity.Invernada;
import lucas.tcc.gestao.bovinos.domain.repository.InvernadaRepository;
import lucas.tcc.gestao.bovinos.web.error.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvernadaService {
    private final InvernadaRepository repo;

    public InvernadaService(InvernadaRepository repo) {
        this.repo = repo;
    }

    public Invernada criar(Invernada i){ return repo.save(i); }
    public List<Invernada> listar(){ return repo.findAll(); }
    public Invernada buscar(Long id){
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Invernada não encontrada"));
    }
    public Invernada atualizar(Long id, Invernada changes){
        Invernada i = buscar(id);
        i.setDescricao(changes.getDescricao());
        i.setUrlFoto(changes.getUrlFoto());
        i.setObservacoes(changes.getObservacoes());
        return repo.save(i);
    }
    public void deletar(Long id){ repo.deleteById(id); }
}
