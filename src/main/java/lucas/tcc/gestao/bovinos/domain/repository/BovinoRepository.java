package lucas.tcc.gestao.bovinos.domain.repository;

import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.domain.entity.Invernada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BovinoRepository extends JpaRepository<Bovino, Long> {
    Optional<Bovino> findByCodigoEpc(String codigoEpc);
    List<Bovino> findByInvernada(Invernada invernada);
}
