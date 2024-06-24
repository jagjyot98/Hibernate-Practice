package com.hibernate.test;

import com.hibernate.entity.Student;
import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class StudentUpdate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Method 1      goes with primary key
//        Student stud = session.get(Student.class,111);  //select * from StudentInfo where primarty key(sno) = 111
//        stud.setMarks(555);
//        session.merge(stud);

        //Method 2 - using HQL (hibernate query language) - applied on Model(class), not on table
        MutationQuery query = session.createMutationQuery("update Student set marks = :marks where name = :name");
        query.setParameter("marks",650.0);
        query.setParameter("name","Ramu");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
