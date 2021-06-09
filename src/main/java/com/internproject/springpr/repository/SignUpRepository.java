package com.internproject.springpr.repository;
import com.internproject.springpr.domain.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// signup has been added
@Repository
public interface SignUpRepository extends JpaRepository<SignUp,Long> {
    SignUp findByMailid(String mail);
    SignUp findByRoleAndMailidAndPass(String role,String mail,String pass);
}