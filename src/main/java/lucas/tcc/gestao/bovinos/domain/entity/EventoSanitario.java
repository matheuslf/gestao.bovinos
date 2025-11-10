package lucas.tcc.gestao.bovinos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento_sanitario")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EventoSanitario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String tipo; // Vacina, Diagnostico, Tratamento

    @Column(columnDefinition = "text")
    private String descricao;

    private LocalDate dataEvento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bovino_id")
    private Bovino bovino;
}
