package lucas.tcc.gestao.bovinos.web.dto.invernada;

import jakarta.validation.constraints.NotBlank;

public record InvernadaRequest(
        @NotBlank String descricao,
        String urlFoto,
        String observacoes
) {}
