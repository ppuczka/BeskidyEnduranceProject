package pl.coderslab.beskidyenduranceproject.entity;

import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "mountains")
public class Mountain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mountainId;

    @Size(max = 50)
    @Column(length = 50, unique = true)
    @NotEmpty
    private String name;


    @NotEmpty
    private int height;

    @ManyToMany(mappedBy = "mountains")
    @NotEmpty
    private List<Trail> trails;

    public Mountain() {
    }

    public Mountain(String name, int height, List<Trail> trails) {
        this.name = name;
        this.height = height;
        this.trails = trails;
    }

    public long getMountainId() {
        return mountainId;
    }

    public void setMountainId(long mountainId) {
        this.mountainId = mountainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Trail> getTrails() {
        return trails;
    }

    public void setTrails(List<Trail> trails) {
        this.trails = trails;
    }
}
