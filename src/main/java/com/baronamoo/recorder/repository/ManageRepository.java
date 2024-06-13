package com.baronamoo.recorder.repository;

import com.baronamoo.recorder.domain.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageRepository extends JpaRepository<Management,Long> {
    Management findByMngName(String mngName);
}