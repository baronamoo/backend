package com.baronamoo.recorder.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RecordItem { //건 테이블

    @Id
    private Long itemNum; //건 번호

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "record_list_label_number")
//    private RecordList list_num; //철 관리번호

    @Column
    private String itemName; //건 제목

    @Column
    private String fst_page; //건 첫 페이지

    @Column
    private String lst_page; // 건 끝 페이지

    @Column
    private String worker; // 작업자

    @Column
    private String reg_class; // 등록 구분

    @Column
    private String effectiveDate; // 시행일자

    @Column
    private String prod_date; // 생산(접수)일자

    @Column
    private String prod_name; // 생산기관명

    @Column
    private String doc_num; // 문서번호

    @Column
    private String save_period; // 보존기간

    @Column
    private String architect; // 기안자

    @Column
    private String manager; // 결재권자

    @Column
    private String sender; // 발신자 수신자 발신자 둘다 넣는건지 물어보기

    @Column
    private String receiver; //수신자

    @Column
    private String e_record; //전자기록물 여부 ,boolean으로 해도 될거같음

}
