package nobody.ecommerce;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import nobody.ecommerce.entity.Customer;
import nobody.ecommerce.entity.Order;
import nobody.ecommerce.entity.enums.Status;

public class ManyToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		
		Customer customer = em.find(Customer.class, 1L);
		
		Order order = new Order();
		
		order.setCustomer(customer);
		order.setRegDate(LocalDateTime.now());
		order.setStatus(Status.ACTIVE);
		order.setTotal(1000d);
		
		em.persist(order);
		
		
		em.getTransaction().commit();
	}

}
