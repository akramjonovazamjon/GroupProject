package com.company.dao;

import com.company.dto.FacultyDTO;
import com.company.entity.Faculty;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;

public class FacultyDao{
    private final SessionFactory sessionFactory;

    public FacultyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean addFaculty(FacultyDTO faculty){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Faculty temp = session.get(Faculty.class, faculty.getName());
        session.getTransaction().commit();
        session.close();
        if(temp != null){
            return false;
        }
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(Faculty.builder().name(faculty.getName()).build());
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Faculty getFaculty(Integer id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Faculty faculty = (Faculty) session.get(Faculty.class, id);
        session.getTransaction().commit();
        session.close();
        return faculty;
    }

//    public List<Faculty> getFaculties(){
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        List<Faculty> faculties = session.createCriteria(Faculty.class).list(); //TODO should check
//        session.getTransaction().commit();
//        session.close();
//        return faculties;
//    }
}
