package com.internproject.springpr.repository;
import java.util.List;

import com.internproject.springpr.domain.GurQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GurQueryRepository extends JpaRepository<GurQuery,Long> {
    List<GurQuery> findByReply(String reply);

    List<GurQuery> findByGurEmail(String gurEmail);

    @Modifying
    @Query("UPDATE GurQuery g SET g.reply = :reply WHERE g.gurQueryContent = :gurQueryContent")
    int updategurreply(@Param("gurQueryContent") String gurQueryContent, @Param("reply") String reply);

}
