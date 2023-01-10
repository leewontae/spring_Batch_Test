package com.example.Spring_Batch_Test;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class OracleTests {


    @Autowired
    com.example.Spring_Batch_Test.querydsl.ORACLE.O_Repository O_Repository;
    @Test
    public void vdsCountTest() {

        log.info("ORCALE DEPT : {}", O_Repository.count());

    }
}