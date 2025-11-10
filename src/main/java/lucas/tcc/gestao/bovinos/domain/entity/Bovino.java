package lucas.tcc.gestao.bovinos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bovino")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bovino {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nomeAnimal;

    @Column(nullable = false, unique = true, length = 64)
    private String codigoEpc; // RFID

    @Column(length = 64)
    private String codigoInterno;

    @Column(length = 64)
    private String numeroBrinco;

    @Column(length = 80)
    private String raca;

    private LocalDate dataNascimento;

    // atributos fisiológicos básicos
    private BigDecimal pesoAtualKg;
    @Column(length = 60)
    private String pelagem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "invernada_id")
    private Invernada invernada;
}
