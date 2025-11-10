package lucas.tcc.gestao.bovinos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invernada")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Invernada {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String descricao;

    @Column(columnDefinition = "text")
    private String urlFoto;

    @Column(columnDefinition = "text")
    private String observacoes;
}
