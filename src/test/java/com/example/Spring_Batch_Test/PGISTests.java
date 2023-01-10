package com.example.Spring_Batch_Test;


import com.example.Spring_Batch_Test.querydsl.PGIS.P_Repository;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class PGISTests {


    @Autowired
    com.example.Spring_Batch_Test.querydsl.PGIS.P_Repository P_Repository;
    @Test
    public void vdsCountTest() {

        log.info("PGIS VDS : {}", P_Repository.count());
    }


}