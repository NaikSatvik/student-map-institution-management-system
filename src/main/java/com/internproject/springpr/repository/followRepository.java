package com.internproject.springpr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.internproject.springpr.domain.follow;

@Repository
public interface followRepository extends JpaRepository<follow,Long>{

    @Modifying
    @Query("Delete from follow where stuName=:stuName and sEmail=:sEmail")
    int unfollow(@Param ("stuName") String stuName, @Param ("sEmail") String sEmail);

    List<follow>  findByStuNameAndStatus(String stuName,String status);

    @Modifying
    @Query("update follow f set f.status=:status where sEmail=:sEmail and stuName=:stuName")
    int updateA(@Param ("stuName") String stuName, @Param ("sEmail") String sEmail ,@Param ("status") String status);

    @Modifying
    @Query("update follow f set f.status=:status where sEmail=:sEmail and stuName=:stuName")
    int updateB(@Param ("stuName") String stuName, @Param ("sEmail") String sEmail ,@Param ("status") String status);
}