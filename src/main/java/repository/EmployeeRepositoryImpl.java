package repository;

import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Employee;
import util.SessionFactoryUtil;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Override
	public List<Employee> findAll() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query<Employee> employeeQuery = session.createQuery("FROM Employee" , Employee.class);
		List<Employee> employeeList = employeeQuery.getResultList();
		
		session.getTransaction().commit();
		session.close();
		return employeeList;
	}

	@Override
	public Employee findById(Integer id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee employeeFound = session.find(Employee.class, id);
		
		session.getTransaction().commit();
		session.close();	
		return employeeFound;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer save(Employee employee) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Integer employeeId = (Integer) session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		
		return employeeId;
	}

	@Override
	public Employee update(Employee employee) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee employeeUpdated = session.merge(employee);
		
		session.getTransaction().commit();
		session.close();
		
		return employeeUpdated;
	}

	@Override
	public void delete(Integer id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee employee = session.find(Employee.class, id);
		session.remove(employee);
		
		session.getTransaction().commit();
		session.close();

	}

}
