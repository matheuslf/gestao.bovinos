package lucas.tcc.gestao.bovinos.web.dto.leitura;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LeituraRequest(
        @NotNull Long bovinoId,
        String antena,
        @NotNull LocalDateTime timestamp
) {}
