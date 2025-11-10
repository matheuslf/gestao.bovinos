package lucas.tcc.gestao.bovinos.web.dto.bovino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BovinoRequest(
        @NotBlank String nomeAnimal,
        @NotBlank String codigoEpc,
        String codigoInterno,
        String numeroBrinco,
        String raca,
        LocalDate dataNascimento,
        BigDecimal pesoAtualKg,
        String pelagem,
        @NotNull Long invernadaId
) {}
