package com.company.service;

import com.company.dao.FacultyDao;
import com.company.dto.FacultyDTO;
import com.company.entity.Faculty;

import java.util.List;

public class FacultyService {
    private final FacultyDao facultyDao;

    public FacultyService(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    public boolean addFaculty(FacultyDTO facultyDTO){
        return facultyDao.addFaculty(facultyDTO);
    }

    public Faculty getFaculty(Integer id){
        return facultyDao.getFaculty(id);
    }
//    public List<Faculty> getFaculties(){
//        return facultyDao.getFaculties();
//    }
}
