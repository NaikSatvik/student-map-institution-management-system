package com.internproject.springpr.repository;
import com.internproject.springpr.domain.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian,Long> {
    Guardian findByGurEmailAndGurPassAndGurStudentmail(String gurEmail,String gurPass,String gurStudentmail);
}