package pl.coderslab.beskidyenduranceproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ranks")
public class Rank {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankId;

    private String name;

    private Float minReqPoints;

    private Float maxReqPoints;

    private Date aquired;

    @ManyToMany
    private List<User> users;


}
