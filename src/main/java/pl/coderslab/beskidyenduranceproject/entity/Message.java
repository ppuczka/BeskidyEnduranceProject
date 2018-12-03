package pl.coderslab.beskidyenduranceproject.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.exception.DataException;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "messages")
@Data
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

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;


}
