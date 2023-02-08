package com.cheocharm.MapZ.comment.domain.repository;

import com.cheocharm.MapZ.comment.domain.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>, CommentRepositoryCustom{
    @Modifying
    @Query("delete from CommentEntity c where c.parentId in :id")
    void deleteAllByIdInQuery(@Param("id") Long id);
}
