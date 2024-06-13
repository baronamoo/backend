package com.baronamoo.recorder.service;

import com.baronamoo.recorder.domain.Management;
import com.baronamoo.recorder.domain.RecordList;
import com.baronamoo.recorder.dto.RecordListRowRequestDTO;
import com.baronamoo.recorder.dto.RecordListRowResponseDTO;
import com.baronamoo.recorder.handler.ExcelSheetHandler;
import com.baronamoo.recorder.repository.ManageRepository;
import com.baronamoo.recorder.repository.RecordListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class RecordListServiceImpl implements RecordListService {

    private final RecordListRepository recordListRepository;
    private final ManageRepository manageRepository;

    @Override
    public void readHead(String filePath) throws IOException{
        int norder_number = -1; //순번
        int nlabel_number = -1; //관리번호
        int nsave_place = -1; //보존장소
        int nbox_number = -1; //상자번호
        int nloc_info = -1; //서가위치정보
        int nprod_dept = -1; //생산부서
        int nMngDept = -1; //관리부서
        int ntrans_dept = -1; //이관부서
        int nsrt_year = -1; //시작연도
        int nend_year = -1; //종료연도
        int nrec_name = -1; //기록물철 제목
        int nrec_content = -1; //기록물철 설명
        int nbox_name = -1; //보존상자 제목
        int ntype = -1; //유형
        int nitem_num = -1; // 권 호수
        int nunit_task = -1; //단위과제
        int nsave_period = -1; //보존기간
        int nsp_exp = -1; //보존기간 만료
        int neval_review_year = -1; //평가심의연도
        int neval_review_result = -1; //평가심의결과
        int ndiscard_year = -1; //폐기연도
        int ntrans_year = -1; //이관연도
        int nnote = -1; //비고

        File file = new File(filePath);
        log.info("readHead 실행중..");
        ExcelSheetHandler excelSheetHandler = ExcelSheetHandler.readExcel(file);
        log.info("filePath를 통해 excelSheetHandler 생성");
        List<List<String>> excelDatas = excelSheetHandler.getRows();
        log.info("엑셀 데이터 로드");

        int rowLimit = excelDatas.size();

        excelSheetHandler.endRow(0);
        List<String> heads;
        heads = excelDatas.get(0);

        for(String str : heads){
            System.out.println(str);
        }

        log.info("출력완료");

    }

    /**
     *
     * @param filePath
     * @throws IOException
     */
    @Override
    public void saveExcel(String filePath) throws IOException{

        int norder_number = -1; //순번
        int nlabel_number = -1; //관리번호
        int nsave_place = -1; //보존장소
        int nbox_number = -1; //상자번호
        int nloc_info = -1; //서가위치정보
        int nprod_dept = -1; //생산부서
        int nMngDept = -1; //관리부서
        int ntrans_dept = -1; //이관부서
        int nsrt_year = -1; //시작연도
        int nend_year = -1; //종료연도
        int nrec_name = -1; //기록물철 제목
        int nrec_content = -1; //기록물철 설명
        int nbox_name = -1; //보존상자 제목
        int ntype = -1; //유형
        int nitem_num = -1; // 권 호수
        int nunit_task = -1; //단위과제
        int nsave_period = -1; //보존기간
        int nsp_exp = -1; //보존기간 만료
        int neval_review_year = -1; //평가심의연도
        int neval_review_result = -1; //평가심의결과
        int ndiscard_year = -1; //폐기연도
        int ntrans_year = -1; //이관연도
        int nnote = -1; //비고

        File file = new File(filePath);
        log.info("saveExcel 실행중..");
        ExcelSheetHandler excelSheetHandler = ExcelSheetHandler.readExcel(file);
        log.info("filePath를 통해 excelSheetHandler 생성");
        List<List<String>> excelDatas = excelSheetHandler.getRows();
        log.info("엑셀 데이터 로드");

        int rowLimit = excelDatas.size();

        List<String> heads;
        heads = excelSheetHandler.getHeader();

        String head;

        for(int i = 0; i < heads.size(); i++){
            head = heads.get(i);
            if(head == null){
                head = "NULL";
            }else{
                head = head.replaceAll(" ", "");
            }
            switch (head){
                case "NULL":
                    break;
                case "관리번호": nlabel_number = i;
                    break;
                case "서가위치정보\n" + "(서가-열-층)","서가위치정보","위치정보\n" + "(서고-서가-열-층)": nloc_info = i;
                    break;
                case "상자번호": nbox_number = i;
                    break;
                case "보존장소": nsave_place = i;
                    break;
                case "생산부서": nprod_dept = i;
                    break;
                case "관리부서": nMngDept = i;
                    break;
                case "기록물철명", "기록물철제목": nrec_name = i;
                    break;
                case "기록물내용", "기록물설명": nrec_content = i;
                    break;
                case "보존상자제목": nbox_name = i;
                    break;
                case "생산년도", "생산연도", "시작연도","시작년도": nsrt_year = i;
                    break;
                case "종료연도", "종료년도": nend_year = i;
                    break;
                case "유형": ntype = i;
                    break;
                case "권호수": nitem_num = i;
                    break;
                case "단위업무": nunit_task = i;
                    break;
                case "보존기간": nsave_period = i;
                    break;
                case "보존기간만료": nsp_exp = i;
                    break;
                case "폐기연도", "폐기년도": ndiscard_year = i;
                    break;
                case "비고": nnote = i;
                    break;
                case "평가심의연도": neval_review_year = i;
                    break;
                case "평가심의년도": neval_review_year = i;
                    break;
                case "평가심의결과": neval_review_result = i;
                    break;
                default:;
                    break;
            }

        }

        List<RecordList> recordLists = new ArrayList<>();
        List<Management> managements = new ArrayList<>();

        int rowCounter = 0;
        int batchSize = 1000; //배치 사이즈


        for(List<String> dataRow : excelDatas){
            if(rowCounter != 0){
                Long labelNumber = makePkToInt(inputData(dataRow, nlabel_number)); //관리번호

                String orderNumber = inputData(dataRow, norder_number); //순번

                String boxNumber = inputData(dataRow, nbox_number); //상자번호

                String savePlace = inputData(dataRow, nsave_place); //보존장소

                String locInfo = inputData(dataRow, nloc_info); //서가위치정보

                String prodDept = inputData(dataRow, nprod_dept); //생산부서

                String mngDept = inputData(dataRow, nMngDept); //관리부서 + 추가됨

                String transDept = inputData(dataRow, ntrans_dept); //이관부서

                String srtYear = inputData(dataRow, nsrt_year); //시작연도

                String endYear = inputData(dataRow, nend_year); //종료연도

                String recName = inputData(dataRow, nrec_name); //기록물철 제목

                String recContent = inputData(dataRow, nrec_content); //기록물철 설명 + 추가됨

                String boxName = inputData(dataRow, nbox_name); //보존상자 제목

                String type = inputData(dataRow, ntype); //유형

                String itemNum = inputData(dataRow, nitem_num); // 권 호수 + 추가됨

                String unitTask = inputData(dataRow, nunit_task); // 단위과제

                String savePeriod = inputData(dataRow, nsave_period); //보존기간

                String spExpired = inputData(dataRow, nsp_exp); //보존기간 만료 + 추가됨

                String evalReviewYear = inputData(dataRow, neval_review_year); //평가 심의연도

                String evalReviewResult = inputData(dataRow, neval_review_result); //평가심의결과

                String discardYear = inputData(dataRow, ndiscard_year); //폐기연도

                String transYear = inputData(dataRow, ntrans_year); //이관연도

                String note = inputData(dataRow, nnote); //비고

                RecordList recordList = RecordList.builder()
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

                Management management = Management.builder()
                        .mngName(mngDept)
                        .build();

                recordLists.add(recordList);
                managements.add(management);
            }
            if (rowCounter % batchSize == 0 || rowCounter == rowLimit) {
                recordListRepository.saveAll(recordLists);
                manageRepository.saveAll(managements);
                recordLists.clear();
                managements.clear();
                log.info("Saved {} records", rowCounter);
            }
            rowCounter++;
        }
        log.info("데이터 저장 완료");

    }

//    private Long calEvalYear(Long end_year, Long save_period){
//        if(end_year == null || save_period == null){
//            return null;
//        } else {
//            return end_year + save_period + 1;
//        }
//
//    }

    private Long makePkToInt(String str){
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }
    private String inputData(List<String> dataRow, int num){
        if(num == -1){
            return "-1";
        }else {
            return dataRow.get(num);
        }
    }

    @Override
    public RecordListRowResponseDTO addRow(RecordListRowRequestDTO dto){
        RecordList recordList = dto.from();

        RecordList newRecord = recordListRepository.save(recordList);

        return newRecord.from();
    }

    @Override
    public void deleteRow(Long id){
        recordListRepository.deleteById(id);
    }

    @Override
    public RecordListRowResponseDTO modifyRow(RecordListRowRequestDTO dto){
        Long id = dto.getLabelNumber();
        RecordList recordList = recordListRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("존재하지 않는 아이디입니다"));

        recordList.change(dto);
        return recordList.from();
    }

}
