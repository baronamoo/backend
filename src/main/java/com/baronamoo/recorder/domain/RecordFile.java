package com.baronamoo.recorder.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RecordFile { //철 테이블
    @Id
    private Long file_num; //철 관리번호

    @Column
    private String psv_method; //보존방법

    @Column
    private String archival_form; //기록물 형태

    @Column
    private String num_of_items; //건 수

    @Column
    private String num_of_pages; // 쪽 수

    @Column
    private String scan_chk; // 스캔 확인

    @Column
    private String num_of_copies; // 권 수
}
