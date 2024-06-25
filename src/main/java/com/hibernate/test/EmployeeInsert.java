package com.hibernate.test;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeInsert {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee emp = new Employee();
//        emp.setEno(222);
        emp.setEname("CDE");
        emp.setEsalary(2000);
        session.persist(emp);
        transaction.commit();
        session.close();
    }
}
