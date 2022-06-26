package com.selahattinkabasakal.interprobe.homework1.comments.service;

import com.selahattinkabasakal.interprobe.homework1.comments.converter.CommentMapper;
import com.selahattinkabasakal.interprobe.homework1.comments.dao.CommentsDao;
import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentResponseDto;
import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.comments.service.entityservice.CommentEntityService;
import com.selahattinkabasakal.interprobe.homework1.generic.exceptions.RecordNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentEntityService commentEntityService;
    private final CommentsDao commentsDao;


    public List<CommentResponseDto> findAll(){

        List<Comments> commentsList = commentEntityService.findAll();

        return CommentMapper.INSTANCE.convertToCommentDtoList(commentsList);
    }

    public CommentResponseDto findById(Long id){

        Comments comment = commentEntityService.findById(id).orElseThrow(()-> new RecordNotFoundException("Comment Not find Id: "+ id));

        return CommentMapper.INSTANCE.convertToCommentResponseDto(comment);
    }

    public CommentResponseDto save(CommentSaveRequestDto commentSaveRequestDto){

        Comments comment = CommentMapper.INSTANCE.convertToComment(commentSaveRequestDto);
        comment = commentEntityService.save(comment);

        return CommentMapper.INSTANCE.convertToCommentResponseDto(comment);
    }
    public void delete(Long id){

        commentEntityService.delete(id);
    }

    public void delete(Comments comment){

        commentEntityService.delete(comment);
    }

    public boolean isExist(Long id){

        return commentEntityService.isExist(id);
    }

    public CommentResponseDto update(CommentUpdateRequestDto commentUpdateRequestDto) {

        boolean isExist = commentEntityService.isExist(commentUpdateRequestDto.getId());

        if (!isExist){ throw new RecordNotFoundException("No Record Find to Update Id: "+ commentUpdateRequestDto.getId());}

        Comments comment = CommentMapper.INSTANCE.convertToComment(commentUpdateRequestDto);

        comment = commentEntityService.save(comment);

        return CommentMapper.INSTANCE.convertToCommentResponseDto(comment);
    }


    public  List<CommentResponseDto>  findByProductId(Long id) {
        List<Comments> commentsList = commentsDao.findCommentsByProductId(id);

        return CommentMapper.INSTANCE.convertToCommentDtoList(commentsList);

    }

    public List<CommentResponseDto> findByProductIdBetweenDates(Long id, Date startDate, Date endDate) {
        List<Comments> commentsList = commentsDao.findCommentsByProductIdAndCommentDateBetween(id,startDate,endDate);

        return CommentMapper.INSTANCE.convertToCommentDtoList(commentsList);
    }

    public List<CommentResponseDto> findByUserId(Long id) {

        List<Comments> commentsList = commentsDao.findCommentsByUserId(id);

        return CommentMapper.INSTANCE.convertToCommentDtoList(commentsList);
    }

    public List<CommentResponseDto> findByUserIdBetweenDates(Long id, Date startDate, Date endDate) {
        List<Comments> commentsList = commentsDao.findCommentsByUserIdAndCommentDateBetween(id,startDate,endDate);

        return CommentMapper.INSTANCE.convertToCommentDtoList(commentsList);
    }
}
