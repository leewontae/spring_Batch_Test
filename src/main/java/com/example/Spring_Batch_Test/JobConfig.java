package com.example.Spring_Batch_Test;

import com.example.Spring_Batch_Test.DEPT.DEPTREADER;
import com.example.Spring_Batch_Test.DEPT.DEPTREDUCE;
import com.example.Spring_Batch_Test.DEPT.DEPTWRITER;
import com.example.Spring_Batch_Test.querydsl.ORACLE.O_DEPT;
import com.example.Spring_Batch_Test.querydsl.PGIS.P_DEPT;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableBatchProcessing
public class JobConfig extends DefaultBatchConfigurer {

    public final JobBuilderFactory JOBBuilder;
    public final StepBuilderFactory STEPBuilder;

    public JobConfig(JobBuilderFactory JOBBuilder, StepBuilderFactory STEPBuilder) {

        this.JOBBuilder = JOBBuilder;
        this.STEPBuilder = STEPBuilder;
    }

    @Bean
    public Job DEPTJob(Step DEPTSTEP){

        return JOBBuilder.get("DEPTJob")
                .start(DEPTSTEP)
                .build();
    }


    @Bean
    public Step DEPTSTEP(DEPTREADER READER, DEPTREDUCE REDUCE, DEPTWRITER WRITER){

        return STEPBuilder.get("DEPTSTEP").<O_DEPT, P_DEPT>chunk(100)
                .reader(READER)
                .processor(REDUCE)
                .writer(WRITER)
                .allowStartIfComplete(true)
                .build();
    }

    @Override
    public void setDataSource(@NonNull DataSource ignored) {/* NOTHING */}
    // 찾아볼것
}
