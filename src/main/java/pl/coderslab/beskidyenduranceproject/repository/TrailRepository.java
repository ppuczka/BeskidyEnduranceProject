package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.beskidyenduranceproject.entity.Trail;

import java.util.List;

public interface TrailRepository extends JpaRepository<Trail, Long> {

    List<Trail> getAllByTownsNameContainingIgnoreCase(String townName);

    List<Trail> getAllByMountainsNameContainingIgnoreCase(String mountainName);

    List<Trail> findFirst5ByOrderByRatingDesc();

//    @Query("SELECT t FROM Trail t left join on Town town where town.name like :name")
//    List<Trail> findByTownsOrMountainsName(@Param("name") String name);

}
