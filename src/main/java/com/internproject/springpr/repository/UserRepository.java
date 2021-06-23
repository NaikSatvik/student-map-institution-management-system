package com.internproject.springpr.repository;
import java.util.List;
import com.internproject.springpr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByStuSem(String stuSem);
    List<User> findByStuEmail(String stuEmail);
    List<User> findAll();
    User findById(String id);

    @Query("SELECT id from User WHERE stuEmail = :mail")
    public String count(@Param("mail") String mail);

    @Modifying
    @Query("UPDATE User s SET s.stuMobile = :stuMobile, s.stuAddress = :stuAddress, s.stuPincode = :stuPincode, s.stuHobby = :stuHobby WHERE s.stuEmail = :stuEmail")
    int update(@Param("stuEmail") String stuEmail, @Param("stuMobile") String stuMobile);

    @Modifying
    @Query("UPDATE User u SET u.stuSem = :stuSem WHERE u.stuEmail = :stuEmail")
    int updateSem(@Param("stuEmail") String stuEmail, @Param("stuSem") String stuSem);
}