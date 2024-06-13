package com.baronamoo.recorder.exceltest;


import com.baronamoo.recorder.service.RecordListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

//@Transactional
@SpringBootTest
public class SaveExcelTest {

    private final RecordListService recordListService;

    @Autowired //생성자를 만들었다면 여기에 @autowired 달아줘야됨. 아니면 junit5에서 parameter 오류 발생시킴
    public SaveExcelTest(RecordListService recordListService) {
        this.recordListService = recordListService;
    }

    @Test
    void saveTest() throws IOException {

        //recordListService.saveExcel("C:\\Users\\lg\\OneDrive\\바탕 화면\\준오 프로젝트\\excelFiles\\0201 총목록1.xlsx");
        //recordListService.saveExcel("C:\\Users\\lg\\OneDrive\\바탕 화면\\준오 프로젝트\\excelFiles\\★ 용인도시공사 목록 취합본 0331 v1.0.xlsx");
        recordListService.saveExcel("C:\\Users\\lg\\OneDrive\\바탕 화면\\준오 프로젝트\\excelFiles\\002. 2023년 한국임업진흥원 문서 목록(수정).xlsx");
    }

    @Test
    void readHeadTest() throws IOException{
        recordListService.readHead("C:\\Users\\lg\\OneDrive\\바탕 화면\\준오 프로젝트\\excelFiles\\0201 총목록1.xlsx");
    }

}