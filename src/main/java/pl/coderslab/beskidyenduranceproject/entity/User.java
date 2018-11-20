package pl.coderslab.beskidyenduranceproject.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100)
    private String firstName;

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100)
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"),
                    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @NotEmpty
    private String password;

    private int active;

    @NotEmpty
    @Email(message = "Podaj poprawny adres e-mail")
    @Column(unique = true)
    private String email;

    @ManyToMany
    private List<Trail> trails;


//    @OneToMany
//    private List<Message> messageList;

    private long points;

//     do relacji potrzebne ranks, challenges, messages,



}
