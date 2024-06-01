package com.example.employability.Repository;

import com.example.employability.Entity.Condidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondidatureRepository extends JpaRepository<Condidature, Long> {
}
