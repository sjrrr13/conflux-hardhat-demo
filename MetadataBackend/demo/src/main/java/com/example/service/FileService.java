package com.example.service;

import com.example.utils.FilePathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.entity.RespBean;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FileService {
    Logger logger = LoggerFactory.getLogger(FileService.class.getName());

    // general service
    @ResponseBody
    public byte[] generalGetFile(String filename, String format) {
        try {
            String path = FilePathUtil.fileDir() + filename
                    + "/" + filename + format;
            FileInputStream fileInputStream = new FileInputStream(path);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes, 0, fileInputStream.available());
            return bytes;
        } catch (IOException e) {
            logger.error("IOException in FileService: {}", e.getMessage());
            return new byte[0];
        }
    }

    // request without token id
    public RespBean<String> noTokenId() {
        return RespBean.badRequest("Need token id");
    }

    // file not found
    @ResponseBody
    public byte[] fileNotFound(String filename) {
        try {
            logger.error("File not found: {}", FilePathUtil.fileDir() + filename);
            String path = FilePathUtil.fileDir() + "NotFound.jpeg";
            FileInputStream fileInputStream = new FileInputStream(path);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes, 0, fileInputStream.available());
            return bytes;
        } catch (IOException e) {
            logger.error("IOException in FileService: {}", e.getMessage());
            return new byte[0];
        }
    }

    // special services...
}
