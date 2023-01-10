package com.example.Spring_Batch_Test;


import com.example.Spring_Batch_Test.querydsl.PGIS.P_DEPT;
import lombok.extern.slf4j.Slf4j;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class PGISTests {


    @Autowired
    com.example.Spring_Batch_Test.querydsl.PGIS.P_Repository P_Repository;
    @Test
    public void vdsCountTest() {

        log.info("PGIS  : {}", P_Repository.count());
        Stream<P_DEPT> stream = P_Repository.findAll().stream();
        List<P_DEPT> list = P_Repository.findAll();
        list.forEach(a -> log.info(a.getDNAME() +" / " +a.getLOC()+" / "+a.getDEPTNO()));
    }

}