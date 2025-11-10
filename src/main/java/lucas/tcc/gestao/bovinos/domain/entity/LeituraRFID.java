package lucas.tcc.gestao.bovinos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "leitura_rfid")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LeituraRFID {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String antena;

    private LocalDateTime timestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bovino_id")
    private Bovino bovino;
}
