package lucas.tcc.gestao.bovinos.domain.repository;

import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.domain.entity.LeituraRFID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeituraRfidRepository extends JpaRepository<LeituraRFID, Long> {
    List<LeituraRFID> findByBovino(Bovino bovino);
}
