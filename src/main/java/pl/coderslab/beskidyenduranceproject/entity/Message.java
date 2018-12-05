package pl.coderslab.beskidyenduranceproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @Size(max = 50)
    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    private boolean status;

    @CreationTimestamp
    private Date created;

    @ManyToOne(fetch = FetchType.EAGER)
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    private User receiver;

}
