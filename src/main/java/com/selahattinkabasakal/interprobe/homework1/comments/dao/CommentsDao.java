package com.selahattinkabasakal.interprobe.homework1.comments.dao;

import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */

public interface CommentsDao extends JpaRepository<Comments, Long> {


    List<Comments> findCommentsByProductId(Long id);

    List<Comments> findCommentsByProductIdAndCommentDateBetween(Long id, Date startDate, Date endDate);

    List<Comments> findCommentsByUserId(Long id);

    List<Comments> findCommentsByUserIdAndCommentDateBetween(Long id, Date startDate, Date endDate);
}
