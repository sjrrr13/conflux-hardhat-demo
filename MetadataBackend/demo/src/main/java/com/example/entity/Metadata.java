package com.example.entity;

import lombok.Data;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metadata {
    @JSONField(name = "name")
    private String name;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "image")
    private String image;

    @JSONField(name = "token_id")
    private int tokenId;

    public Metadata(MetadataInfo metadataInfo, int tokenId) {
        setName(metadataInfo.getName());
        setDescription(metadataInfo.getDescription());
        setImage(metadataInfo.getImage());
        setTokenId(tokenId);
    }
}
