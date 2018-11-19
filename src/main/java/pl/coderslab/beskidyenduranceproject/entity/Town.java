package pl.coderslab.beskidyenduranceproject.entity;


import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long townId;

    @Column(length = 100, unique = true)
    @Size(max = 100)
    @NotEmpty
    private String name;

    @NotEmpty
    private int height;

    @Column(length = 1000)
    private String decription;

    @ManyToMany(mappedBy = "towns")
    @NotEmpty
    private List<Trail> trailList;

    public Town() {
    }

    public Town(String name, int height, String decription, List<Trail> trailList) {
        this.name = name;
        this.height = height;
        this.decription = decription;
        this.trailList = trailList;
    }

    public long getTownId() {
        return townId;
    }

    public void setTownId(long townId) {
        this.townId = townId;
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

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public List<Trail> getTrailList() {
        return trailList;
    }

    public void setTrailList(List<Trail> trailList) {
        this.trailList = trailList;
    }
}
