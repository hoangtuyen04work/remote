package com.demo.component_scan.repo;

import com.demo.component_scan.model.entity.KM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KMRepository extends JpaRepository<KM, Long> {

    @Query("SELECT km.KMCode FROM KM km ORDER BY km.KMCode desc ")
    Optional<String> findFirstByKMCode();

    @Query("SELECT COUNT(km) FROM KM km WHERE km.KMCode = :kmcode")
    Long coundKMCode(@Param("kmcode")String KMCode);

    @Query("SELECT COUNT(km) FROM KM km WHERE km.KMName = :kmname")
    Long coundKMName(@Param("kmname") String KMName);
}
