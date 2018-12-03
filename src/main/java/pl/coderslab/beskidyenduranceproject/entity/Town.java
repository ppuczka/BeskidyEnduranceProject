package pl.coderslab.beskidyenduranceproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long townId;

    @Column(length = 100, unique = true)
    @Size(max = 100)
    @NotEmpty(message = "Pole nie może być puste")
    private String name;

    @DecimalMin(value = "5", message = "Podana wartość musi być większa od 5")
    @NotNull(message = "Pole nie może być puste")
    private Integer height;

    @Column(length = 1000)
    private String decription;

    @ManyToMany(mappedBy = "towns")
    private List<Trail> trailList;

}
