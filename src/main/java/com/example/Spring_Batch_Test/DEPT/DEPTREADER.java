package com.example.Spring_Batch_Test.DEPT;

import com.example.Spring_Batch_Test.querydsl.ORACLE.O_DEPT;
import com.example.Spring_Batch_Test.querydsl.ORACLE.O_Repository;
import com.example.Spring_Batch_Test.querydsl.PGIS.P_DEPT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@Component
public class DEPTREADER implements ItemReader<O_DEPT> {

    private final O_Repository O_Repository;

    private Iterator<O_DEPT> all; //pgis ITERATOR 생성
    public DEPTREADER(com.example.Spring_Batch_Test.querydsl.ORACLE.O_Repository O_Repository) {
        this.O_Repository = O_Repository;
    }

    @BeforeStep
    public void before() {

        all = O_Repository.findAll().iterator();
        log.info("STMA_ROUTE_ELVT 조회 끝");
    }

    @Override
    public O_DEPT read()  {

        if (all != null && all.hasNext()) {
            return all.next();
        } else {
            return null;
        }
    }
}
