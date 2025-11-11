package lucas.tcc.gestao.bovinos.domain.repository;

import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.domain.entity.LeituraRFID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LeituraRfidRepository extends JpaRepository<LeituraRFID, Long> {
    List<LeituraRFID> findByBovino(Bovino bovino);

    @Query("""
           SELECT l FROM LeituraRFID l
           WHERE l.timestamp = (
               SELECT MAX(l2.timestamp)
               FROM LeituraRFID l2
               WHERE l2.bovino = l.bovino
           )
           """)
    List<LeituraRFID> findUltimasLeiturasPorBovino();

    @Query("""
           SELECT l FROM LeituraRFID l
           WHERE l.bovino = :bovino
           ORDER BY l.timestamp DESC
           LIMIT 1
           """)
    Optional<LeituraRFID> findUltimaLeituraPorBovino(Bovino bovino);
}
