package com.internproject.springpr.repository;
import java.util.List;

import com.internproject.springpr.domain.StudentQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentQueryRepository extends JpaRepository<StudentQuery,Long> {
    List<StudentQuery> findByReply(String reply);

    List<StudentQuery> findByStuEmail(String stuEmail);

    @Modifying
    @Query("UPDATE StudentQuery s SET s.reply = :reply WHERE s.stuQuery = :stuQuery")
    int updatestureply(@Param("stuQuery") String stuQuery, @Param("reply") String reply);
}