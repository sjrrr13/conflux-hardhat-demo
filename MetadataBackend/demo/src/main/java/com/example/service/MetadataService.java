package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.entity.Metadata;
import com.example.entity.MetadataInfo;
import com.example.entity.RespBean;
import com.example.utils.FilePathUtil;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class MetadataService {
    Logger logger = LoggerFactory.getLogger(MetadataService.class.getName());

    // general service
    public RespBean<Metadata> generalGetMetadata(String filename, String tokenId) {
        StringBuilder content = new StringBuilder();
        try {
            String path = FilePathUtil.metadataDir() + filename
                    + "/" + filename + ".json";
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(path)));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                content.append(temp);
            }
            bufferedReader.close();

            MetadataInfo info = JSON.parseObject(content.toString(), MetadataInfo.class);
            Metadata data = new Metadata(info, Integer.parseInt(tokenId));
            return RespBean.success(data);
        } catch (IOException e) {
            logger.error("IOException in MetadataService: {}", e.getMessage());
            return RespBean.internal();
        } catch (NumberFormatException e) {
            logger.error("NumberFormatException in MetadataService: {}", e.getMessage());
            return RespBean.internal();
        }
    }

    // request without token id
    public RespBean<String> noTokenId() {
        return RespBean.badRequest("Need token id");
    }

    // metadata not found
    public RespBean<Metadata> metadataNotFound(String filename) {
        logger.error("Metadata not found: {}", filename);
        return RespBean.notFound();
    }

    // special services...
}
