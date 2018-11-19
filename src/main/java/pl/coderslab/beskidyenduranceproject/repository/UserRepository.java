package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beskidyenduranceproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}

