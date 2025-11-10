package lucas.tcc.gestao.bovinos.domain.repository;

import lucas.tcc.gestao.bovinos.domain.entity.Bovino;
import lucas.tcc.gestao.bovinos.domain.entity.EventoSanitario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoSanitarioRepository extends JpaRepository<EventoSanitario, Long> {
    List<EventoSanitario> findByBovino(Bovino bovino);
}
