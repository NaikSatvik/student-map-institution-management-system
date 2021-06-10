package com.internproject.springpr.repository;
import java.util.List;
import com.internproject.springpr.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    List<Faculty> findByFacEmail(String facEmail);

    @Query("SELECT id from Faculty WHERE facEmail = :mail")
    public String count(@Param("mail") String mail);
    
    @Modifying
    @Query("UPDATE Faculty f SET f.facMobile = :facMobile, f.facAddress = :facAddress, f.facPincode = :facPincode, f.facExp = :facExp, f.facQuali = :facQuali, f.facSpeci = :facSpeci WHERE f.facEmail = :facEmail")
    int update(@Param("facEmail") String facEmail, @Param("facMobile") String facMobile, @Param("facAddress") String facAddress, @Param("facPincode") String facPincode, @Param("facExp") String facExp, @Param("facQuali") String facQuali,@Param("facSpeci") String facSpeci);
}