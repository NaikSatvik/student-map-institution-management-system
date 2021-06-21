package com.internproject.springpr.repository;
import com.internproject.springpr.domain.StudentQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentQueryRepository extends JpaRepository<StudentQuery,Long> {

}