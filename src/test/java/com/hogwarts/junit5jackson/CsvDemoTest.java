package com.hogwarts.junit5jackson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author wyl
 * @create 2022-01-30 17:04
 */
public class CsvDemoTest {
    //CSV文件有header时
    //实体类的成员变量
    //成员变量与header名一致
    @Test
    void csvReadWithHeader() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        //带着header读取,默认间隔为英文逗号
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
                .with(orderLineSchema)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(orderLines.readAll());
        //[OrderLine{item='No. 9 Sprockets', quantity=12, unitPrice=1.23, orderDate=2019-04-17}, OrderLine{item='Widget (10mm)', quantity=4, unitPrice=3.45, orderDate=2022-01-16}]
    }

    //实体类的成员变量
    //成员变量与header名不一致,相当于进行重命名
    @Test
    void csvReadWithHeader1() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        //带着header读取,默认间隔为英文逗号
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        MappingIterator<OrderList> orderLines = csvMapper.readerFor(OrderList.class)
                .with(orderLineSchema)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(orderLines.readAll());
    //[OrderList{otherItem='No. 9 Sprockets', qua=12, price=1.23, date=2019-04-17}, OrderList{otherItem='Widget (10mm)', qua=4, price=3.45, date=2022-01-16}]
    }

    //直接声明类型解析
    @Test
    void csvReadWithHeaderMap() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        //.setSkipFirstDataRow(true) 第一行header不解析，重新添加Column,可改变名称
        CsvSchema schema = CsvSchema.builder().setSkipFirstDataRow(true)
                .addColumn("item1")
                .addColumn("quantity1")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        MappingIterator<Object> objectMappingIterator = csvMapper.readerForMapOf(String.class)
                // 注意：不需要包装
                .with(schema)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(objectMappingIterator.readAll());
        //[{item1=No. 9 Sprockets, quantity1=12, unitPrice=1.23, orderDate=2019-04-17}, {item1=Widget (10mm), quantity1=4, unitPrice=3.45, orderDate=2022-01-16}]
    }

    //CSV文件没有header时
    // 直接声明类型解析
    @Test
    void csvReadWithoutHeaderMap() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        //.setSkipFirstDataRow(true) 第一行header不解析，重新添加Column,可改变名称
        //读取时不需要再跳过第一行，直接解析
        //CsvSchema schema = CsvSchema.builder()
        CsvSchema schema = CsvSchema.builder().setSkipFirstDataRow(false)
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        //readerForMapOf
        MappingIterator<Object> objectMappingIterator = csvMapper.readerForMapOf(String.class)
                // 注意：不需要包装
                .with(schema)
                .readValues(new File("src/test/resources/orderlist.csv"));
        System.out.println(objectMappingIterator.readAll());
        //[{item=No. 9 Sprockets, quantity=12, unitPrice=1.23, orderDate=2019-04-17}, {item=Widget (10mm), quantity=4, unitPrice=3.45, orderDate=2022-01-16}]

    }
    //CSV文件没有header时
    //实体类的成员变量
    //成员变量与header名一致
    @Test
    void csvReadWithoutHeader() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        //无header读取,需要给每一列添加名称且名称与OrderLine中一致
        CsvSchema schema = CsvSchema.builder()
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
                .with(schema)
                .readValues(new File("src/test/resources/orderlist.csv"));
        System.out.println(orderLines.readAll());
        //[OrderLine{item='No. 9 Sprockets', quantity=12, unitPrice=1.23, orderDate=2019-04-17}, OrderLine{item='Widget (10mm)', quantity=4, unitPrice=3.45, orderDate=2022-01-16}]
    }

    //实体类的成员变量
    //成员变量与header名不一致,相当于在OrderList中对header进行重命名
    @Test
    void csvReadWithoutHeader1() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        //带着header读取,默认间隔为英文逗号
        //无header读取,需要给每一列添加名称且名称与OrderLine中一致,不能更改,相当于加了header
        CsvSchema schema = CsvSchema.builder()
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        //功能上等价的便捷方法： mapper.registerModules(mapper.findModules());
        //我们需要使用 findAndRegisterModules方法，以便 Jackson正确处理我们的日期
        //Jackson也可以自动搜索所有模块，不需要我们手动注册
        csvMapper.findAndRegisterModules();
        MappingIterator<OrderList> orderLines = csvMapper.readerFor(OrderList.class)
                .with(schema)
                .readValues(new File("src/test/resources/orderlist.csv"));
        System.out.println(orderLines.readAll());
        //[OrderList{otherItem='No. 9 Sprockets', qua=12, price=1.23, date=2019-04-17}, OrderList{otherItem='Widget (10mm)', qua=4, price=3.45, date=2022-01-16}]
    }
}
