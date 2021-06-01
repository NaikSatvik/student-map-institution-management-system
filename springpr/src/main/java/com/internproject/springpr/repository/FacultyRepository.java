package com.internproject.springpr.repository;
import com.internproject.springpr.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Faculty findByFacEmailAndFacPass(String facEmail,String facPass);
}