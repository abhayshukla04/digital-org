package com.engg.digitalorg.api;

import com.engg.digitalorg.exception.DigitalOrgException;
import com.engg.digitalorg.model.entity.Icon;
import com.engg.digitalorg.model.request.CardRequest;
import com.engg.digitalorg.model.response.CardResponse;
import com.engg.digitalorg.model.response.IconResponse;
import io.swagger.annotations.*;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/card")
@Api(tags = "Card Services", description = "Card Api")
@CrossOrigin(origins = {"https://digital-org.herokuapp.com/", "http://localhost:4200"})
public interface CardApi {

    @ApiOperation(value = "Create new card", notes = "User to create new card", response = ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "accepted operation", response = ResponseEntity.class),
                           @ApiResponse(code = 400, message = "Invalid Request")})
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    ResponseEntity createCard(@RequestBody CardRequest cardRequest) throws DigitalOrgException, IOException;

    @ApiOperation(value = "Upload Image", notes = "Upload custom image", response = ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "ok", response = ResponseEntity.class),
                           @ApiResponse(code = 400, message = "Unknown image type")})
    @PostMapping(path = "/upload/{card-id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
    public ResponseEntity<CardResponse> uplaodImage(@PathVariable("card-id") int cardId , @RequestPart("file") MultipartFile file) throws IOException ;

    @ApiOperation(value = "Download image", notes = "Download image for card", response = ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "ok", response = ResponseEntity.class), @ApiResponse(code = 400, message = "Bad Request")})
    @GetMapping(path = "/download/{card-id}")
    public ResponseEntity<IconResponse> downloadImage(@PathVariable("card-id") int cardId) throws IOException ;

    @ApiOperation(value = "Delete card", notes = "Delete requested card", response = ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code = 204, message = "Deleted", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad Request")})
    @DeleteMapping(path = "/{card-id}/{email}", produces = "application/json")
    ResponseEntity deleteCard(@PathVariable("card-id") int cardId, @PathVariable("card-id") String email) throws DigitalOrgException;

}
