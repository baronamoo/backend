package com.baronamoo.recorder.dto;

import com.baronamoo.recorder.domain.RecordList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordListRowRequestDTO {

    Long labelNumber; //관리번호

    String savePlace;  //보존장소

    String boxNumber;  //상자번호

    String locInfo;  //서가위치정보

    String prodDept;  //생산부서

    String mngDept; // 관리부서

    String transDept;  //이관부서

    String srtYear;  //시작연도

    String endYear;  //종료연도

    String recName; //기록물철 제목

    String recContent;  //기록물철 내용

    String boxName;  //보존상자 제목

    String type;  //유형

    String itemNum;  //권 호수

    String unitTask;  //단위과제

    String savePeriod;  //보존기간

    String spExpired;  //보존기간 만료

    String evalReviewYear;  //평가심의연도

    String evalReviewResult;  //평가심의결과

    String discardYear;  //폐기연도

    String transYear;  //이관연도

    String note;  //비고

    public RecordList from(){
        return RecordList.builder()
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
}
