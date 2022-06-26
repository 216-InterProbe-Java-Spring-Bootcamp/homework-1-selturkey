package com.selahattinkabasakal.interprobe.homework1.comments.converter;

import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentResponseDto;
import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductResponseDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponseDto convertToCommentResponseDto(Comments comment);
    Comments convertToComment(CommentUpdateRequestDto commentUpdateRequestDto);
    Comments convertToComment(CommentSaveRequestDto commentSaveRequestDto);
;

    List<CommentResponseDto> convertToCommentDtoList(List<Comments> commentsList);


}