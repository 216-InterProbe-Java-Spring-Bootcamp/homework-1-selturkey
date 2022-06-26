package com.selahattinkabasakal.interprobe.homework1.comments.service.entityservice;

import com.selahattinkabasakal.interprobe.homework1.comments.dao.CommentsDao;
import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.generic.service.BaseEntityService;
import org.springframework.stereotype.Service;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Service
public class CommentEntityService extends BaseEntityService<Comments, CommentsDao> {
    public CommentEntityService(CommentsDao dao) {
        super(dao);
    }


}
