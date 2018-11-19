package pl.coderslab.beskidyenduranceproject.entity;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotEmpty;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotEmpty
//    @Size(max = 100)
    @Column(length = 100)
    private String firstName;

    @NotEmpty
//    @Size(max = 100)
    @Column(length = 100)
    private String lastName;

    @NotEmpty
//    @Size(max = 50)
    @Column(length = 50, unique = true)
    private String nickName;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @ManyToMany
    private List<Trail> trails;

//    @OneToMany
//    private List<Message> messageList;

    private long points;

//     do relacji potrzebne ranks, challenges, messages,


    public User() {
    }

    public User(String firstName, String lastName, String nickName, String email, List<Trail> trails, long points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.trails = trails;
        this.points = points;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Trail> getTrails() {
        return trails;
    }

    public void setTrails(List<Trail> trails) {
        this.trails = trails;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;

    }
}
