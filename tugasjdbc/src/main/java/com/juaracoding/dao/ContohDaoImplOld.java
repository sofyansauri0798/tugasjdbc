//package com.juaracoding.dao;
//
//import com.juaracoding.core.IDao;
//import com.juaracoding.model.Contoh;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.CallableStatementCreator;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.SqlParameter;
//import org.springframework.stereotype.Repository;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Types;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//@Repository
//public class ContohDaoImplOld implements IDao<Contoh> {
//
//    private JdbcTemplate jdbcTemplate;
//    private String [] strExceptionArr = new String[2];
//    @Autowired
//    public ContohDaoImplOld(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public ResponseEntity<Object> save(Contoh contoh, HttpServletRequest request) {
//        try
//        {
//            List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR));
//            jdbcTemplate.call(new CallableStatementCreator() {
//                @Override
//                public CallableStatement createCallableStatement(Connection con) throws SQLException {
//                    CallableStatement cs = con.prepareCall("{CALL sp_add_mst_contoh(?,?,?,?,?,?)}");
//                    cs.setInt(1, contoh.getContohInt());
//                    cs.setDouble(2, contoh.getContohDouble());
//                    cs.setString(3, contoh.getContohString());
//                    cs.setFloat(4, contoh.getContohFloat());
//                    cs.setBoolean(5, contoh.getContohBoolean());
//                    cs.setDate(6,new java.sql.Date(((Date) contoh.getContohDate()).getTime()));
//                    return cs;
//                }
//            }, parameters);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<Object>("DATA GAGAL DISIMPAN "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<Object>(new HashMap<>(),HttpStatus.CREATED);
//    }
//
//    @Override
//    public ResponseEntity<Object> update(Long id, Contoh contoh, HttpServletRequest request) {
//        try
//        {
//            List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR));
//            jdbcTemplate.call(new CallableStatementCreator() {
//                @Override
//                public CallableStatement createCallableStatement(Connection con) throws SQLException {
//                    CallableStatement cs = con.prepareCall("{CALL sp_update_mst_contoh(?,?,?,?,?,?)}");
//                    cs.setInt(1, contoh.getContohInt());
//                    cs.setDouble(2, contoh.getContohDouble());
//                    cs.setString(3, contoh.getContohString());
//                    cs.setFloat(4, contoh.getContohFloat());
//                    cs.setBoolean(5, contoh.getContohBoolean());
//                    cs.setDate(6,new java.sql.Date(((Date) contoh.getContohDate()).getTime()));
//                    cs.setLong(7,id);
//                    return cs;
//                }
//            }, parameters);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<Object>("DATA GAGAL DISIMPAN "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<Object>(new HashMap<>(),HttpStatus.CREATED);
//    }
//
//    @Override
//    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
//        try
//        {
//            List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR));
//            jdbcTemplate.call(new CallableStatementCreator() {
//                @Override
//                public CallableStatement createCallableStatement(Connection con) throws SQLException {
//                    CallableStatement cs = con.prepareCall("{CALL sp_delete_mst_contoh(?)}");
//                    cs.setLong(1,id);
//                    return cs;
//                }
//            }, parameters);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<Object>("DATA GAGAL DISIMPAN "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<Object>(new HashMap<>(),HttpStatus.CREATED);
//    }
//
//    @Override
//    public Boolean saveDummy(Contoh contoh, HttpServletRequest request) {
//        return true;
//    }
//
//    @Override
//    public Boolean editDummy(Long id, Contoh contoh, HttpServletRequest request) {
//        return true;
//    }
//
//    @Override
//    public Boolean deleteDummy(Long id, HttpServletRequest request) {
//        return true;
//    }
//
//    @Override
//    public Boolean readDummy(String param, String column, HttpServletRequest request) {
//        return true;
//    }
//}
