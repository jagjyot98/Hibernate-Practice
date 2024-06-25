/* Notes:   1. Criteria Builder is used to create criteria/condition based databased query statements.
            2. Prior to Hibernate 6 Criteria Builder API usage:
                Criteria cr = session.createCriteria(Employee.class);
                List<Employee> emplist = cr.list();
                for(Employee emp:emplist)
                System.out.println(emp);
            3. criteriaBuilder.gt = greaterThan
                           .lt = less than
                           .ge = greater than equal to
                           .le = less than equal to
                           .eq = equal to
                           .ne = not equal to
                           .like() = to search for a specified pattern
                                    % = zero, one or more characters (Ram = R%)
                                    _ = one single character  (Ram = R__ )
 */
package com.hibernate.test;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

public class CriteriaDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
//        criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("esalary"),1000));    //fetching data from db based on condition salary >= 1000

        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("ename"),"____"));     //fetching data from db based on condition ename having exactly 4 characters
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("ename"),"__m%"));     //fetching data from db based on condition ename having 3rd character 'm'
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("ename"),"%C%"));     //fetching data from db based on condition ename having character 'C' anywhere in the name

//        criteriaQuery.select(root); //fetching data from database table linked to employee class
        Query query = session.createQuery(criteriaQuery);
        List<Employee> empList = query.getResultList();
        for (Employee emp : empList)
            System.out.println(emp);
        session.close();
    }
}
