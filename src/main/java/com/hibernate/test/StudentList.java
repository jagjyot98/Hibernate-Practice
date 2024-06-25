/* Notes:       Data when fetched from database comes in hash form. to make it readable we need toString method in Object class which converts hash and prints the data in our specified way

 */
package com.hibernate.test;
import java.util.List;
import com.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hibernate.entity.Student;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.SelectionQuery;

public class StudentList {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        SelectionQuery<Student> query = session.createSelectionQuery("from Student", Student.class);
//        here no need for Transaction class, it i sused for insertion, updation or deletion of data in db
        List<Student> studList = query.list();
//        for(Student stud : studList)
//                System.out.println(stud);   //invokes toString() implicitly
//        studList.forEach(stud -> System.out.println(stud));   //java 8 lambda expression
        studList.forEach(System.out::println);      //method reference
        session.close();
        }
}
