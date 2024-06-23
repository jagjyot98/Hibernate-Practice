package com.hibernate.test;

import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;

public class HibernateTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String version = (String) session.createNativeQuery("select version()").getSingleResult();
        System.out.println("my version: " + version);
        session.close();
        HibernateUtil.shutdown();
    }
}
