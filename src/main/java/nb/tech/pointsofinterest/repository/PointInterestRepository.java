package nb.tech.pointsofinterest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nb.tech.pointsofinterest.entity.PointInterest;

@Repository
public interface PointInterestRepository extends JpaRepository<PointInterest, Long>{

}
