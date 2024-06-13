package com.baronamoo.recorder.repository;

import com.baronamoo.recorder.domain.RecordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordListRepository extends JpaRepository<RecordList, Long> {

    RecordList findByMngDept(String mngDept);
}