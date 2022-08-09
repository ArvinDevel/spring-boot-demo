package com.example.restservice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisMapperUnderSameFolderWithApp {
    int mockMethod();
}
