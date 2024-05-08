package nb.tech.pointsofinterest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Point-of-interest")
public class PointInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePOI;
    private Long x;
    private Long y;

    public PointInterest(String namePOI, Long x, Long y) {
        this.namePOI = namePOI;
        this.x = x;
        this.y = y;
    }
}
