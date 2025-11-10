package lucas.tcc.gestao.bovinos.web.dto.invernada;

public record InvernadaResponse(
        Long id,
        String descricao,
        String urlFoto,
        String observacoes
) {}
