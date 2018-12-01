package pl.coderslab.beskidyenduranceproject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.beskidyenduranceproject.entity.Trail;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mountains")
public class Mountain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mountainId;

    @Size(max = 50)
    @Column(length = 50, unique = true)
    @NotEmpty(message = "Pole nie może być puste")
    private String name;

    @NotNull(message = "Pole nie może być puste")
    @DecimalMin(value = "5", message = "Podana wartość musi być większa od 5")
    private int height;

    @ManyToMany(mappedBy = "mountains")
    private List<Trail> trailList;


}
