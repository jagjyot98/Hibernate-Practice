/*  Notes:      Refer to oneToone Mapping image in project folder

 */
package com.hibernate.test;

import com.hibernate.entity.Address;
import com.hibernate.entity.Customer;
import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneMapping {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Address addr = new Address();
        addr.setAddressId(101);
        addr.setAddress("TamilNadu");

        Customer cust = new Customer();
        cust.setCusId(201);
        cust.setCusName("TUV");
        cust.setAddress(addr);

        session.persist(cust);
        session.persist(addr);

        transaction.commit();
        session.close();
    }
}
