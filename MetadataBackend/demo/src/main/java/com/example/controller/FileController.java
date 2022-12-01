package com.example.controller;

import com.example.entity.RespBean;
import com.example.service.FileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    private FileService service = new FileService();

    private static final String JPG = ".jpg";
    private static final String PNG = ".png";
    private static final String JPEG = ".jpeg";

    @RequestMapping(value = {"/file/{name}/{tokenId}"},
            produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getFile(@PathVariable String name, @PathVariable String tokenId) {
        switch (name) {
            case "test":
                return service.generalGetFile(name, JPG);
            default:
                return service.fileNotFound(name);
        }
    }

    @RequestMapping("/file/{name}")
    public RespBean<String> noTokenId(@PathVariable String name) {
        return service.noTokenId();
    }
}
