package STUB.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "performances")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private long score;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false)
    private Course course;

    public Performance(final Long score, final Course course) {
        this.score = score;
        this.course = course;
    }
}
