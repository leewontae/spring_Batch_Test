package com.example.Spring_Batch_Test.querydsl.PGIS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface P_Repository extends JpaRepository<P_DEPT,String> {

}
