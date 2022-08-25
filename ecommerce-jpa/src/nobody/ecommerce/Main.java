package nobody.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import nobody.ecommerce.entity.Customer;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setFirstName("Fernando");
		customer.setLastName("Miranda");
		em.persist(customer);
		em.getTransaction().commit();
	}

}
