package lucas.tcc.gestao.bovinos.web.dto.evento;

import java.time.LocalDate;

public record EventoResponse(
        Long id,
        Long bovinoId,
        String tipo,
        String descricao,
        LocalDate dataEvento
) {}
