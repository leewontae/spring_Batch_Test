package com.example.Spring_Batch_Test.querydsl.ORACLE;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface O_Repository extends JpaRepository<O_DEPT,String> {

}
