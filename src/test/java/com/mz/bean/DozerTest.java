package com.mz.bean;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.classmap.RelationshipType;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.FieldsMappingOptions;
import com.github.dozermapper.core.loader.api.TypeMappingOptions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static com.github.dozermapper.core.loader.api.FieldsMappingOptions.*;
import static com.github.dozermapper.core.loader.api.TypeMappingOptions.*;

/**
 * @author mz
 * @version V1.0
 * @Title DozerTest
 * @Package com.mz.bean
 * @Description
 * @date 2020/7/31 5:18 下午
 */
@Testable
public class DozerTest {

    @Test
    public void testCopy() {
        BeanMappingBuilder beanMappingBuilder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(OriginalBean.class, TargetBean.class,
                        TypeMappingOptions.oneWay(),
                        mapId("fieldFirst"),
                        mapNull(true),dateFormat("")
                ).fields("fieldSecond", "fieldSecond",
                        copyByReference(),
                        collectionStrategy(true, RelationshipType.NON_CUMULATIVE),
                        hintA(String.class),
                        hintB(Integer.class),
                        FieldsMappingOptions.oneWay(),
                        useMapId("fieldFirst")
                );
            }
        };

        Mapper mapper = DozerBeanMapperBuilder.create()
                .withMappingBuilder(beanMappingBuilder)
                .build();
        OriginalBean originalBean = new OriginalBean();
        originalBean.setFieldFirst("first");
        originalBean.setFieldSecond("2");
        TargetBean map = mapper.map(originalBean, TargetBean.class);
        System.err.println(map);
    }
}