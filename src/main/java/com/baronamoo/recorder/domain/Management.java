package com.baronamoo.recorder.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mngNum; //관리부서번호

//    @OneToMany(mappedBy = "management",cascade = CascadeType.ALL)
//    private List<RecordList> recordLists = new ArrayList<>();

    @Column(length = 256)
    private String mngName; //관리부서명

}
