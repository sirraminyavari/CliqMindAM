package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Feature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, Integer>, FeatureRepoCustom {

    @Transactional(readOnly = true)
    @Query(
            value = "SELECT f FROM Feature f WHERE (:active IS NULL OR f.active=:active) AND ((:ids) IS NULL OR f.id in (:ids))",
            countQuery = "SELECT COUNT(f) FROM Feature f WHERE (:active IS NULL OR f.active=:active) AND ((:ids) IS NULL OR f.id in (:ids))"
    )
    Page<Feature> find(List<Integer> ids, Boolean active, Pageable pageable);

}
