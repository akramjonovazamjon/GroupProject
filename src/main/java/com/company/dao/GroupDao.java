package com.company.dao;

import com.company.dto.GroupDTO;
import com.company.entity.Faculty;
import com.company.entity.Group;
import com.company.service.FacultyService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GroupDao {
    private final SessionFactory sessionFactory;
    private final FacultyService facultyService;

    public GroupDao(SessionFactory sessionFactory, FacultyService facultyService) {
        this.sessionFactory = sessionFactory;
        this.facultyService = facultyService;
    }
    public boolean addGroup(GroupDTO groupDTO) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Group group = (Group) session.get(Group.class, groupDTO.getName());
        session.getTransaction().commit();
        session.close();

        if (group != null) {
            return false;
        }

        session = sessionFactory.openSession();
        session.beginTransaction();
        Faculty faculty = facultyService
                .getFaculty(groupDTO.getFacultyId());
        group = new Group();
        group.setName(groupDTO.getName());
        group.setFaculty(faculty);
        session.save(group);
        session.getTransaction();
        session.close();
        return true;
    }
    public Group getGroup(Integer groupId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Group group = session.get(Group.class, groupId);
        session.getTransaction().commit();
        session.close();
        return group;
    }
//    public List<Group> getGroups(Integer facultyId){
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        List<Group> groups = session.createCriteria(Group.class).list(); //TODO should check
//        session.getTransaction().commit();
//        session.close();
//        return groups;
//    }
}
