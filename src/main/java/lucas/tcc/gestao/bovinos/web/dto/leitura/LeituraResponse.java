package lucas.tcc.gestao.bovinos.web.dto.leitura;

import java.time.LocalDateTime;

public record LeituraResponse(
        Long id,
        Long bovinoId,
        String antena,
        LocalDateTime timestamp
) {}
