package com.example.Spring_Batch_Test.DEPT;

import com.example.Spring_Batch_Test.querydsl.PGIS.P_DEPT;
import com.example.Spring_Batch_Test.querydsl.PGIS.P_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class DEPTWRITER implements ItemWriter<P_DEPT> {

    private final P_Repository P_Repository;

    public DEPTWRITER(com.example.Spring_Batch_Test.querydsl.PGIS.P_Repository p_repository) {
        P_Repository = p_repository;
    }

    @Override
    public void write(List<? extends P_DEPT> list) throws Exception {

        log.info(" P_DEPT 저장 ");

        P_Repository.saveAll(list);

        log.info(" P_DEPT 저장 끝");
    }

    @AfterStep
    public void after() {

        P_Repository.flush();
        log.info("DEPT Job 종료");
    }

}
