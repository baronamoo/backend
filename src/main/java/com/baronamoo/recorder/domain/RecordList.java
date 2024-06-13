package com.baronamoo.recorder.domain;

import com.baronamoo.recorder.dto.RecordListRowRequestDTO;
import com.baronamoo.recorder.dto.RecordListRowResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RecordList {

    @Id
    private Long labelNumber; //관리번호

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "management_mng_name")
    private Management management; //관리부서 필드 fk

    @Column(length = 16)
    private String orderNumber; //순번

    /**
    * 상자번호
    */
    @Column(length = 16)
    private String boxNumber; //상자번호

    @Column(length = 256)
    private String savePlace; //보존장소

    @Column(length = 32)
    private String locInfo; //서가위치정보

    @Column(length = 256)
    private String prodDept; //생산부서

    @Column(length = 256) // 데이터베이스와 매핑되지 않는 임시 필드
    private String mngDept; // 엑셀로부터 받아온 관리부서명 //관리부서 + 추가됨

    @Column(length = 256)
    private String transDept; //이관부서

    @Column(length = 16)
    private String srtYear; //시작연도

    @Column(length = 16)
    private String endYear; //종료연도

    @Column(length = 1024)
    private String recName; //기록물철 제목

    @Column(length = 2048)
    private String recContent; //기록물철 설명 + 추가됨

    @Column(length = 256)
    private String boxName; //보존상자 제목

    @Column(length = 256)
    private String type; //유형

    @Column(length = 16)
    private String itemNum; // 권 호수 + 추가됨

    @Column(length = 256)
    private String unitTask; // 단위과제

    @Column(length = 16)
    private String savePeriod; //보존기간, String으로

    @Column(length = 16)
    private String spExpired; //보존기간 만료 + 추가됨

    @Column(length = 16)
    private String evalReviewYear; //평가 심의연도

    @Column(length = 256)
    private String evalReviewResult; //평가심의결과

    @Column(length = 16)
    private String discardYear; //폐기연도

    @Column(length = 32)
    private String transYear; //이관연도

    @Column(length = 1024)
    private String note; //비고


//    @PostLoad
//    private void fillTransient() {
//        if (manDept != null && management == null) {
//            management = Management.builder()
//                    .mngName(manDept)
//                    .build();
//        }
//    }



//    @OneToMany(mappedBy = "record_list",cascade = CascadeType.ALL)
//    private List<RecordItem> items = new ArrayList<>();
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "record_file_file_num")
//    private RecordFile file;

    public RecordListRowResponseDTO from(){
        return RecordListRowResponseDTO.builder()
                .labelNumber(labelNumber)
                .savePlace(savePlace)
                .boxNumber(boxNumber)
                .locInfo(locInfo)
                .prodDept(prodDept)
                .mngDept(mngDept)
                .transDept(transDept)
                .srtYear(srtYear)
                .endYear(endYear)
                .recName(recName)
                .recContent(recContent)
                .boxName(boxName)
                .type(type)
                .itemNum(itemNum)
                .unitTask(unitTask)
                .savePeriod(savePeriod)
                .spExpired(spExpired)
                .evalReviewYear(evalReviewYear)
                .evalReviewResult(evalReviewResult)
                .discardYear(discardYear)
                .transYear(transYear)
                .note(note)
                .build();
    }

    public void change(RecordListRowRequestDTO dto) {
        this.labelNumber = dto.getLabelNumber(); //관리번호

        this.savePlace = dto.getSavePlace();  //보존장소

        this.boxNumber = dto.getBoxNumber();  //상자번호

        this.locInfo = dto.getLocInfo();  //서가위치정보

        this.prodDept = dto.getProdDept();  //생산부서

        this.mngDept = dto.getMngDept(); // 관리부서

        this.transDept = dto.getTransDept();  //이관부서

        this.srtYear = dto.getSrtYear();  //시작연도

        this.endYear = dto.getEndYear();  //종료연도

        this.recName = dto.getRecName(); //기록물철 제목

        this.recContent = dto.getRecContent();  //기록물철 내용

        this.boxName = dto.getBoxName();  //보존상자 제목

        this.type = dto.getType();  //유형

        this.itemNum = dto.getItemNum();  //권 호수

        this.unitTask = dto.getUnitTask();  //단위과제

        this.savePeriod = dto.getSavePeriod();  //보존기간

        this.spExpired = dto.getSpExpired();  //보존기간 만료

        this.evalReviewYear = dto.getEvalReviewYear();  //평가심의연도

        this.evalReviewResult = dto.getEvalReviewResult();  //평가심의결과

        this.discardYear = dto.getDiscardYear();  //폐기연도

        this.transYear = dto.getTransYear();  //이관연도

        this.note = dto.getNote();  //비고
    }

}
