package pl.coderslab.beskidyenduranceproject.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "trails")
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trailId;

    @Column(length = 100)
    @NotEmpty(message = "Pole nie może być puste")
    @Size(max = 100, message = "Nazwa jest za długa")
    private String name;

//    @NotEmpty(message = "Pole nie może być puste")
    private double length;

//    @NotEmpty(message = "Pole nie może być puste")
    private int uphill;

    @NotEmpty(message = "Pole nie może być puste")
    @Size(max = 50)
    @Column(length = 50)
    private String type;

    private String description;

    @NotEmpty(message = "Pole nie może być puste")
    private String difficluty;

    @ManyToMany
//    @NotEmpty(message = "Pole nie może być puste")
    private List<Mountain> mountains;

    @ManyToMany
//    @NotEmpty(message = "Pole nie może być puste")
    private List<Town> towns;


}
