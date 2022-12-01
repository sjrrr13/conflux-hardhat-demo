package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Metadata;
import com.example.entity.RespBean;
import com.example.service.MetadataService;

@RestController
public class MetadataController {
    private MetadataService service = new MetadataService();

    @RequestMapping("/metadata/{name}/{tokenId}")
    public RespBean<Metadata> getMetadata(@PathVariable String name, @PathVariable String tokenId) {
        switch (name) {
            case "test":
                return service.generalGetMetadata(name, tokenId);
            default:
                return service.metadataNotFound(name);
        }
    }

    @RequestMapping("/metadata/{name}")
    public RespBean<String> noTokenId(@PathVariable String name) {
        return service.noTokenId();
    }
}
