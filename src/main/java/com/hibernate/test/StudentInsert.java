package com.hibernate.test;

import com.hibernate.entity.Student;
import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentInsert {
    public static void main(String[] args){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();      //for database connection: contains all the properties from configuration file
        Session session = sessionFactory.openSession();     //for database transactions
        Transaction transaction = session.beginTransaction();
        Student stud = new Student();
        stud.setSno(222);
        stud.setName("Ramu");
        stud.setMarks(500.0);
        session.persist(stud);      //insert into StudentInfo values (?,?,?)
        transaction.commit();
        session.close();
    }
}
