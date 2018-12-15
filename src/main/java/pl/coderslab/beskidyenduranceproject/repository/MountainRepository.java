package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;

import java.util.List;

public interface MountainRepository extends JpaRepository<Mountain, Long> {

    @Query("select m from Mountain m where lower(m.name) like %?1%")
    Mountain findByName(String name);

}
