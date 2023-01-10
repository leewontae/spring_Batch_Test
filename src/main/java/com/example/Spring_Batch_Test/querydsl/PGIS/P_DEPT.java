package com.example.Spring_Batch_Test.querydsl.PGIS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="DEPT")
public class P_DEPT {

    @Id
    private Integer DEPTNO;
    private String DNAME;
    private String LOC;
}
