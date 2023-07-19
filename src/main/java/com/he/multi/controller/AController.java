package com.he.multi.controller;

import com.he.multi.dao.GradesDao;
import com.he.multi.pojo.Grades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("a")
public class AController {

    @Autowired
    private GradesDao gradesDao;



    @RequestMapping("getString")
    public String getString(){
        List<Grades> grades = gradesDao.selectList(null);
        return grades.toString();
    }
}
