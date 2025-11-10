package lucas.tcc.gestao.bovinos.service;

import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.domain.entity.EventoSanitario;
import lucas.tcc.gestao.bovinos.domain.repository.EventoSanitarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoSanitarioService {
    private final EventoSanitarioRepository repo;
    private final BovinoService bovinoService;

    public EventoSanitarioService(EventoSanitarioRepository repo, BovinoService bovinoService) {
        this.repo = repo;
        this.bovinoService = bovinoService;
    }

    public EventoSanitario criar(EventoSanitario e, Long bovinoId){
        Bovino b = bovinoService.buscar(bovinoId);
        e.setBovino(b);
        return repo.save(e);
    }

    public List<EventoSanitario> listar(){ return repo.findAll(); }
    public List<EventoSanitario> listarPorBovino(Long bovinoId){
        return repo.findByBovino(bovinoService.buscar(bovinoId));
    }
}
