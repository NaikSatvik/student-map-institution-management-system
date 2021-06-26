package com.internproject.springpr.repository;
import java.util.List;
import com.internproject.springpr.domain.Res_SemOne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Res_SemOneRepository extends JpaRepository<Res_SemOne, Long> {
    List<Res_SemOne> findByEmailidAndSemester(String emailid,String semester);
}