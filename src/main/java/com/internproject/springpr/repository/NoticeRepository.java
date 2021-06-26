package com.internproject.springpr.repository;
import java.util.List;
import com.internproject.springpr.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {
    @Query("SELECT n FROM Notice n WHERE n.expDate >= :expDate")
    List<Notice> findByExpDate(String expDate);
}