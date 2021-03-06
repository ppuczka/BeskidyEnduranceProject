package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.beskidyenduranceproject.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Integer>  {

    Role findByRole(String role);

}
