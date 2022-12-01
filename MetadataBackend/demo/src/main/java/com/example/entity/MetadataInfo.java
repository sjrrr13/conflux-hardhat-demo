package com.example.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.alibaba.fastjson.annotation.JSONField;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetadataInfo {
    @JSONField(name = "name")
    private String name;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "image")
    private String image;
}
