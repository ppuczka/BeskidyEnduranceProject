package pl.coderslab.beskidyenduranceproject.entity;


import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "trails")
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trailId;

    @Column(length = 100)
    @NotEmpty
    @Size(max = 100)
    private String name;

    @NotEmpty
    private double length;

    @NotEmpty
    private int uphill;

    @NotEmpty
    @Size(max = 50)
    @Column(length = 50)
    private String type;


    private String description;

    @NotEmpty
    private String difficluty;

    @ManyToMany
    @NotEmpty
    private List<Mountain> mountains;

    @ManyToMany
    @NotEmpty
    private List<Town> towns;

    public Trail() {
    }

    public Trail(String name, double length, int uphil, String type, String description, String difficluty,
                 List<Mountain> mountains, List<Town> towns) {
        this.name = name;
        this.length = length;
        this.uphill = uphil;
        this.type = type;
        this.description = description;
        this.difficluty = difficluty;
        this.mountains = mountains;
        this.towns = towns;

    }

    public long getTrailId() {
        return trailId;
    }

    public void setTrailId(long trailId) {
        this.trailId = trailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getUphill() {
        return uphill;
    }

    public void setUphill(int uphill) {
        this.uphill = uphill;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficluty() {
        return difficluty;
    }

    public void setDifficluty(String difficluty) {
        this.difficluty = difficluty;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }
}
