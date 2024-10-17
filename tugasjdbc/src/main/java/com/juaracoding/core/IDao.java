package com.juaracoding.core;

import com.juaracoding.model.Contoh;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IDao<T> {

    public ResponseEntity<Object> save(T t, HttpServletRequest request);
    public ResponseEntity<Object> update(Long id, T t ,HttpServletRequest request);
    public ResponseEntity<Object> delete(Long id,HttpServletRequest request);
    public ResponseEntity<Object> findAll(int page,int size ,String sort,String sortBy,HttpServletRequest request);
    public Boolean findByParam(String param, String column, HttpServletRequest request);
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request);
}
