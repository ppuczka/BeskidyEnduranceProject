package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beskidyenduranceproject.entity.Trail;

import java.util.List;

public interface TrailRepository extends JpaRepository<Trail, Long> {

    List<Trail> findFirst5ByOrderByRatingDesc();

}
