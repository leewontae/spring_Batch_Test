package com.example.Spring_Batch_Test.DEPT;

import com.example.Spring_Batch_Test.querydsl.ORACLE.O_DEPT;
import com.example.Spring_Batch_Test.querydsl.PGIS.P_DEPT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DEPTREDUCE implements ItemProcessor<O_DEPT, P_DEPT> {


    @Override
    public P_DEPT process(O_DEPT o_dept) throws Exception {
        log.info("변환 시작 ");
        return new P_DEPT(o_dept);
    }
}
