package lucas.tcc.gestao.bovinos.service;

import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.domain.entity.LeituraRFID;
import lucas.tcc.gestao.bovinos.domain.repository.LeituraRfidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeituraRfidService {
    private final LeituraRfidRepository repo;
    private final BovinoService bovinoService;

    public LeituraRfidService(LeituraRfidRepository repo, BovinoService bovinoService) {
        this.repo = repo;
        this.bovinoService = bovinoService;
    }

    public LeituraRFID criar(LeituraRFID l, Long bovinoId){
        Bovino b = bovinoService.buscar(bovinoId);
        l.setBovino(b);
        return repo.save(l);
    }

    public List<LeituraRFID> listar(){ return repo.findAll(); }
    public List<LeituraRFID> listarPorBovino(Long bovinoId){
        return repo.findByBovino(bovinoService.buscar(bovinoId));
    }
    public List<LeituraRFID> listarUltimasPorBovino() {
        return repo.findUltimasLeiturasPorBovino();
    }

    public Optional<LeituraRFID> buscarUltimaPorBovino(Long bovinoId) {
        Bovino bovino = bovinoService.buscar(bovinoId);
        return repo.findUltimaLeituraPorBovino(bovino);
    }

}
