package com.internproject.springpr.repository;
import java.util.List;

import com.internproject.springpr.domain.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian,Long> {
    Guardian findByGurEmailAndGurPassAndGurStudentmail(String gurEmail,String gurPass,String gurStudentmail);
    List<Guardian> findAll();
    List<Guardian> findByGurEmail(String gurEmail);

    @Query("SELECT id from Guardian WHERE gurEmail = :mail")
    public String count(@Param("mail") String mail);

    @Modifying
    @Query("UPDATE Guardian s SET s.gurMobile = :gurMobile, s.gurAddress = :gurAddress, s.gurPincode = :gurPincode WHERE s.gurEmail = :gurEmail")
    int updateGurProfile(@Param("gurEmail") String gurEmail, @Param("gurMobile") String gurMobile, @Param("gurAddress") String gurAddress, @Param("gurPincode") String gurPincode);
}