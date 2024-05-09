package nb.tech.pointsofinterest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nb.tech.pointsofinterest.entity.PointInterest;

@Repository
public interface PointInterestRepository extends JpaRepository<PointInterest, Long>{

    @Query("""
            SELECT p FROM PointInterest p
            WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
            """)
    List<PointInterest> findNearMe(@Param("xMin")long xMin,
                                    @Param("xMax") long xMax,
                                    @Param("yMin") long yMin,
                                    @Param("yMax") long yMax);

}
