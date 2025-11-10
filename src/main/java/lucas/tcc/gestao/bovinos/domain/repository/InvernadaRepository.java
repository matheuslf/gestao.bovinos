package lucas.tcc.gestao.bovinos.domain.repository;

import lucas.tcc.gestao.bovinos.domain.entity.Invernada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvernadaRepository extends JpaRepository<Invernada, Long> {}