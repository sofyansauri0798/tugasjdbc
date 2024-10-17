package com.juaracoding.curd;

import com.juaracoding.Main;
import com.juaracoding.dao.ContohDaoImpl;
import com.juaracoding.model.Contoh;
import com.juaracoding.util.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;

@SpringBootTest(classes = Main.class)
public class TestCobainCrud extends AbstractTestNGSpringContextTests {


    @Autowired
    private ContohDaoImpl contohDao;

    private static DataGenerator dataGenerator ;

    private Random rand;
    private static final Boolean isBool [] = {true,false};

    private MockHttpServletRequest request;
    private String strMessage;

    @BeforeTest
    public void initTest(){
        rand = new Random();
        dataGenerator = new DataGenerator();
        request = new MockHttpServletRequest();
    }

    @Test
    public void saveWithInsertTemplateToMstCobaTest(){
        Contoh contoh = new Contoh();
        contoh.setContohInt(rand.nextInt(10000));
        contoh.setContohDouble(rand.nextDouble(59999.99));
        contoh.setContohFloat(rand.nextFloat(19999.99F));
        contoh.setContohString(dataGenerator.dataNamaBelakang());
        contoh.setContohBoolean(isBool[rand.nextInt(isBool.length)]);
        contoh.setContohDate(new Date());
        ResponseEntity<Object> response = contohDao.save(contoh,request);
        Assert.assertEquals(response.getStatusCode().value(),201);
    }
}