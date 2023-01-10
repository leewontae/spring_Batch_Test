package com.example.Spring_Batch_Test.querydsl.ORACLE;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor //파라미터 없는 생성자 생성
@Table(name="DEPT")
public class O_DEPT {

    @Id
    private Integer DEPTNO;
    private String DNAME;
    private String LOC;
}