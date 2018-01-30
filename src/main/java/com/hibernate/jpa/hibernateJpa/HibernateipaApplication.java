package com.hibernate.jpa.hibernateJpa;

import com.hibernate.jpa.hibernateJpa.entity.Address;
import com.hibernate.jpa.hibernateJpa.entity.Book;
import com.hibernate.jpa.hibernateJpa.entity.Car;
import com.hibernate.jpa.hibernateJpa.entity.ContactInfo;
import com.hibernate.jpa.hibernateJpa.entity.Employee;
import com.hibernate.jpa.hibernateJpa.entity.Employer;
import com.hibernate.jpa.hibernateJpa.entity.Person;
import com.hibernate.jpa.hibernateJpa.entity.PetrolCar;
import com.hibernate.jpa.hibernateJpa.entity.Publisher;
import com.hibernate.jpa.hibernateJpa.entity.Student;
import com.hibernate.jpa.hibernateJpa.entity.Vehicle;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateipaApplication implements CommandLineRunner {

	@Autowired
	private SessionFactory sessionFactory;
	public static void main(String[] args) {
		SpringApplication.run(HibernateipaApplication.class, args);
	}

	//access command line arguments
	@Override
	public void run(String... args) throws Exception {

		System.out.println("This is spring boot hebernate JPA standalone application");


		//testEmbedObject();
		//testOnetoOne();
		//testOnetoMany();
		//testManytoMany();
		//fetchLazyEagar();
		//inheritanceStratergy();

		//testHQL();

		//testCache();
	}

	private  void testEmbedObject() {
		Person person= new Person();
		person.setName("Chida");
		person.setGender("Male");
		person.setAge(35);


		//embedded Object as component

		Address address = new Address();
		address.setStreet("1 st street");
		address.setCity("Chennai");
		address.setPincode("614723");
		person.setPrimaryAddress(address);

		Address address1 = new Address();
		address1.setStreet("2 st street");
		address1.setCity("Tanjore");
		address1.setPincode("8788990");
		person.setSecondaryAddress(address1);

		//Element collection
		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclieNo("7826");
		vehicle.setVehicleType("Two wheeler");
		vehicle.setBrand("Honda");

		person.getVehicles().add(vehicle);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

	private void testOnetoOne(){
		Student student = new Student();
		student.setName("Chida");
		student.setRollno(1234);

		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setCity("Pattukkottai");
		contactInfo.setPhone("9841792223");

		student.setContactInfo(contactInfo);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(contactInfo);
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	private void testOnetoMany(){
		Employer employer = new Employer();
		employer.setName("Google");
		employer.setLocation("USA");

		Employee employee = new Employee();
		employee.setEmpId("EMP 1");
		employee.setName("Chida");
		//employee.setEmployer(employer);

		Employee employee1 = new Employee();
		employee1.setEmpId("EMP 2");
		employee1.setName("Jana");
		//employee1.setEmployer(employer);

		employer.getEmployees().add(employee);
		employer.getEmployees().add(employee1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employer);
		/*session.save(employee);
		session.save(employee1);*/

		session.getTransaction().commit();
		session.close();
	}

	public void testManytoMany(){
		Book book = new Book();

		book.setName("Java");
		book.setAuthor("Chida");

		Book book1 = new Book();

		book1.setName("Hibernate");
		book1.setAuthor("varada");

		Publisher publisher = new Publisher();
		publisher.setName("E-Book Publish");

		Publisher publisher1 = new Publisher();
		publisher1.setName("Oreily Publish");

		book.getPublishers().add(publisher);
		book.getPublishers().add(publisher1);

		book1.getPublishers().add(publisher);
		book1.getPublishers().add(publisher1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.save(book1);
		session.getTransaction().commit();
		session.close();
	}

	public void fetchLazyEagar(){
		Session session = sessionFactory.openSession();
		Book book = session.get(Book.class, new Long(1));
		System.out.println(book.getName());
		System.out.println(book.getPublishers().size());
		session.close();
	}

	public void inheritanceStratergy(){
		Car car = new Car();
		car.setName("Car 1");
		car.setBrand("Maruti");

		PetrolCar petrolCar = new PetrolCar();
		petrolCar.setName("Petrol car");
		petrolCar.setBrand("Hundai");
		petrolCar.setEngine("VDI");
		petrolCar.setFuelType("Petrol");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(car);
		session.save(petrolCar);
		session.getTransaction().commit();
		session.close();
	}

	public  void testHQL(){

		//select all
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Car");
		List<Car> cars = query.list();
		System.out.println("Total cars " + cars.size());

		// where clause
		query = session.createQuery("from Car where unid > 1");
		cars = query.list();
		cars.iterator().forEachRemaining(car -> System.out.println(car.getName()));

		// paginated

		query = session.createQuery("from Car");
		query.setFirstResult(1);
		query.setMaxResults(1);
		cars = query.list();
		cars.iterator().forEachRemaining(car -> System.out.println(car.getName()));

		//individual coloumn


		query = session.createQuery("select name from Car");

		query.list().iterator().forEachRemaining(name -> System.out.println(name));

		// aggregate

		query = session.createQuery("select max(unid) from Car");

		query.list().iterator().forEachRemaining(name -> System.out.println(name));


		session.getTransaction().commit();
		session.close();

	}

	public void testCache(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Loading first");
		Person person = session.get(Person.class,new Long(1));
		System.out.println(person.getName());
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Loading again");
		person= session.get(Person.class,new Long(1));
		System.out.println(person.getAge());

		session.getTransaction().commit();
		session.close();



	}

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}
}
