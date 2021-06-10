package com.bezkoder.spring.security.postgresql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ASRepository extends JpaRepository<com.bezkoder.spring.security.postgresql.models.AnneeScolaire,Long>{

}
