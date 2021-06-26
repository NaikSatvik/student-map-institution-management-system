package com.internproject.springpr.repository;
import com.internproject.springpr.domain.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SignUpRepository extends JpaRepository<SignUp,Long> {
    SignUp findByMailid(String mail);
    SignUp findByRoleAndMailidAndPass(String role,String mail,String pass);

    @Query("SELECT stumailid from SignUp WHERE mailid = :mailid")
    public String getStu(@Param("mailid") String mailid);

    @Modifying
    @Query("UPDATE SignUp s SET s.username = :username, s.pass = :pass WHERE s.mailid = :mailid AND s.stumailid = :stumailid")
    int updateGurEntry(@Param("mailid") String mailid, @Param("stumailid") String stumailid, @Param("username") String username, @Param("pass") String pass);
}