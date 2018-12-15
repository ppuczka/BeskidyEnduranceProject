package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.beskidyenduranceproject.entity.Town;

import java.util.List;

public interface TownRepository extends JpaRepository<Town, Long> {

    @Query("select t from Town t where lower(t.name) like %?1%")
    Town findbyName(String name);


}
