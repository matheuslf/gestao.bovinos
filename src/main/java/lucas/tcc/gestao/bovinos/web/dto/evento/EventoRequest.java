package lucas.tcc.gestao.bovinos.web.dto.evento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoRequest(
        @NotNull Long bovinoId,
        @NotBlank String tipo,
        String descricao,
        @NotNull LocalDate dataEvento
) {}
