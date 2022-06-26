package com.selahattinkabasakal.interprobe.homework1.comments.controller.rest;

import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentResponseDto;
import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.comments.dto.CommentUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.comments.service.CommentsService;
import com.selahattinkabasakal.interprobe.homework1.generic.response.RestResponse;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductResponseDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentsRestController {

    final CommentsService commentsService;
    @GetMapping
    public ResponseEntity findAll(){
        List<CommentResponseDto> commentResponseDtoList = commentsService.findAll();
        return ResponseEntity.ok(RestResponse.of(commentResponseDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        CommentResponseDto commentResponseDto = commentsService.findById(id);
        return ResponseEntity.ok(RestResponse.of(commentResponseDto));
    }
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody CommentSaveRequestDto commentSaveRequestDto){
        CommentResponseDto commentResponseDto = commentsService.save(commentSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(commentResponseDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        commentsService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
    @PutMapping
    public ResponseEntity update(@Valid @RequestBody CommentUpdateRequestDto commentUpdateRequestDto){
        CommentResponseDto commentResponseDto= commentsService.update(commentUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(commentResponseDto));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity findByProductId(@PathVariable Long id){
        List<CommentResponseDto> commentResponseDtoList = commentsService.findByProductId(id);
        return ResponseEntity.ok(RestResponse.of(commentResponseDtoList));
    }

    @GetMapping("/product/{id}/betweenDates")
    public ResponseEntity findByProductIdBetweenDates(@PathVariable Long id, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        List<CommentResponseDto> commentResponseDtoList = commentsService.findByProductIdBetweenDates(id,startDate,endDate);
        return ResponseEntity.ok(RestResponse.of(commentResponseDtoList));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity findByUserId(@PathVariable Long id){
        List<CommentResponseDto> commentResponseDtoList = commentsService.findByUserId(id);
        return ResponseEntity.ok(RestResponse.of(commentResponseDtoList));
    }
    @GetMapping("/user/{id}/betweenDates")
    public ResponseEntity findByUserIdBetweenDates(@PathVariable Long id, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        List<CommentResponseDto> commentResponseDtoList = commentsService.findByUserIdBetweenDates(id,startDate,endDate);
        return ResponseEntity.ok(RestResponse.of(commentResponseDtoList));
    }
}
