package com.juaracoding.controller;

import com.juaracoding.dao.ContohDaoImpl;
import com.juaracoding.model.Contoh;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contoh")
public class ContohController {

    @Autowired
    private ContohDaoImpl dao;

    @PostMapping("/v1")
    public ResponseEntity<Object> save(@RequestBody Contoh contoh, HttpServletRequest request){
        return dao.save(contoh,request);
    }

    @PutMapping("/v1/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(value = "id") Long id,
            @RequestBody Contoh contoh, HttpServletRequest request){
        return dao.update(id,contoh,request);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request){
        return dao.delete(id,request);
    }

    @GetMapping("/v1/{page}/{sort}/{sort-by}")
    public ResponseEntity<Object> findAll(
            @PathVariable(value = "page") Integer page,
            @PathVariable(value = "sort") String sort,
            @PathVariable(value = "sort-by") String sortBy,
            @RequestParam(value = "size") Integer size,
            HttpServletRequest request){
        return dao.findAll(page,size,sort,sortBy,request);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request){
        return dao.findById(id,request);
    }
}