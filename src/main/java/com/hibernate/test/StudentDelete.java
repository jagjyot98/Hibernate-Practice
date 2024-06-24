package com.hibernate.test;

import com.hibernate.entity.Student;
import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class StudentDelete {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //Method1
//        Student stud = new Student();
//        stud.setSno(111);
//        session.remove(stud);

        //Method2
//        Student stud = session.get(Student.class,222);
//        session.remove(stud);

        //Method3   -  for hibernate6 we use this method
        SelectionQuery<Student> query = session.createSelectionQuery("from Student where marks >= :marks",Student.class);
        query.setParameter("marks",400.0);
        List<Student> studList = query.list();
        for(Student stud:studList)
            session.remove(stud);

        //Method4 - for older hibernate versions
//        Query query = session.createQuery("from Student where marks >= :marks");
//        query.setParameter("marks",400.0);
//        List<Student> studList = query.list();
//        for(Student stud:studList)
//            session.delete(stud);

        transaction.commit();
        session.close();
    }
}
