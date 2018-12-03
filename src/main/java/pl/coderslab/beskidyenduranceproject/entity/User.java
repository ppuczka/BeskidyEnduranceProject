package pl.coderslab.beskidyenduranceproject.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotEmpty(message = "Pole nie może być puste")
    @Size(max = 100)
    @Column(length = 100)
    private String firstName;

    @NotEmpty(message = "Pole nie może być puste")
    @Size(max = 100)
    @Column(length = 100)
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"),
                    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @NotEmpty(message = "Pole nie może być puste")
    private String password;

    private Integer active;

    @NotEmpty(message = "Pole nie może być puste")
    @Email(message = "Podaj poprawny adres e-mail")
    @Column(unique = true)
    private String email;

    @ManyToMany
    private List<Trail> trails;

    @CreationTimestamp
    private Date created;

    @OneToMany(mappedBy = "receiver")
    private List<Message> received = new ArrayList<>();

    private long points;


}
