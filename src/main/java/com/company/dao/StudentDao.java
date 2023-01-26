package com.company.dao;

import com.company.dto.StudentDto;
import com.company.entity.Student;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class StudentDao implements BaseDao<Student, StudentDto> {
    private final SessionFactory sessionFactory;
    @Override
    public Student findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student studentEntity = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return studentEntity;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void save(StudentDto studentDTO) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(studentDTO);
        session.getTransaction().commit();
        session.close();
    }
}
