package com.baronamoo.recorder.service;


import com.baronamoo.recorder.dto.RecordListRowRequestDTO;
import com.baronamoo.recorder.dto.RecordListRowResponseDTO;

import java.io.IOException;

public interface RecordListService {

    void readHead(String filePath) throws IOException;

    void saveExcel(String filePath) throws IOException;

    RecordListRowResponseDTO addRow(RecordListRowRequestDTO dto);

    void deleteRow(Long id);

    RecordListRowResponseDTO modifyRow(RecordListRowRequestDTO dto);


}
