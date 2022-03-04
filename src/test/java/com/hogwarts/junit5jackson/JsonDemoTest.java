package com.hogwarts.junit5jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author wyl
 * @create 2022-01-28 21:52
 */
public class JsonDemoTest {
    //Json,List类型解析,直接声明类型
    @Test
    void hashMapTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        TypeReference<List<HashMap<String,Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String,Object>> list = objectMapper.readValue(new File("src/test/resources/orderlist.json"),typeReference);
        System.out.println(list);
        //[{unitPrice=1.23, item=No. 9 Sprockets, quantity=12, orderDate=2019-04-17}, {unitPrice=3.45, item=No. Widget (10mm), quantity=10, orderDate=2022-01-16}]
    }

    //实体类声明，声明实体类OrderLine
    @Test
    void orderLineTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        TypeReference<List<OrderLine>> typeReference = new TypeReference<List<OrderLine>>() {
        };
        //日期转换
        objectMapper.findAndRegisterModules();
        List<OrderLine> orderLines = objectMapper.readValue(new File("src/test/resources/orderlist.json"),typeReference);
        System.out.println(orderLines);
        //[OrderLine{item='No. 9 Sprockets', quantity=12, unitPrice=1.23, orderDate=2019-04-17}, OrderLine{item='No. Widget (10mm)', quantity=10, unitPrice=3.45, orderDate=2022-01-16}]

    }

    //解析无规律json
    @Test
    void orderMapTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        TypeReference<HashMap<String,Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String,Object> stringObjectHashMap = objectMapper.readValue(new File("src/test/resources/order.json"),typeReference);
        System.out.println(stringObjectHashMap);
        //{date=2019-04-17, orderNo=A001, orderLines=[{item=No. 9 Sprockets, quantity=12, unitPrice=1.23}, {item=No. Widget (10mm), quantity=40, unitPrice=3.45}], customerName=Customer, Joe}

    }
    //解析无规律json实体类声明，声明实体类Order
    @Test
    void orderTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        TypeReference<Order> typeReference = new TypeReference<Order>() {
        };
        //日期转换
        mapper.findAndRegisterModules();
        Order order = mapper.readValue(new File("src/test/resources/order.json"),typeReference);
        System.out.println(order);
        //Order{orderNo='A001', date=2019-04-17, customerName='Customer, Joe', orderLines=[OrderLine{item='No. 9 Sprockets', quantity=12, unitPrice=1.23, orderDate=null}, OrderLine{item='No. Widget (10mm)', quantity=40, unitPrice=3.45, orderDate=null}]}
    }

}
