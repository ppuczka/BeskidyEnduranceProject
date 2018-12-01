package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beskidyenduranceproject.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {


}
