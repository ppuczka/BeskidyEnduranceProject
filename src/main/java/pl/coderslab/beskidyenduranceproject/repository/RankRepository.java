package pl.coderslab.beskidyenduranceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.beskidyenduranceproject.entity.Rank;

import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {

}
