package lucas.tcc.gestao.bovinos.web.dto.bovino;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BovinoResponse(
        Long id,
        String nomeAnimal,
        String codigoEpc,
        String codigoInterno,
        String numeroBrinco,
        String raca,
        LocalDate dataNascimento,
        BigDecimal pesoAtualKg,
        String pelagem,
        Long invernadaId,
        String invernadaDescricao
) {}
