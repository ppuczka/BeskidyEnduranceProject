package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beskidyenduranceproject.entity.Trail;

public interface TrailRepository extends JpaRepository<Trail, Long> {

}
