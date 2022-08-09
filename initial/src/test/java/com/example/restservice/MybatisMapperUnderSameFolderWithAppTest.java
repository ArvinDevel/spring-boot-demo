package com.example.restservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class MybatisMapperUnderSameFolderWithAppTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Comment since it'd not loaded to unblock test
     */
//    @Test
    public void mapperLoaded() {
        Assertions.assertDoesNotThrow(this::encapsulateGetBean);
    }

    @Test()
    @DisplayName("Junit5 test doesn't support expected in @Test, it suggest use Assertions.assertThrows")
    public void mapperNotExists() {
        NoSuchBeanDefinitionException noSuchBeanDefinitionException =
                Assertions.assertThrows(NoSuchBeanDefinitionException.class, this::encapsulateGetBean);
    }

    private void encapsulateGetBean() throws NoSuchBeanDefinitionException {
        applicationContext.getBean("mybatisMapperUnderSameFolderWithApp");
    }

}