package cl.praxis.reportes_inmobiliaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reportes")
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "descripcion")
    private String description;

    /*
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
     */
}
