package nobody.ecommerce;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import nobody.ecommerce.entity.Customer;
import nobody.ecommerce.entity.Order;
import nobody.ecommerce.entity.OrderLine;
import nobody.ecommerce.entity.enums.Status;

public class OneToMany {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
	    EntityManager em = entityManagerFactory.createEntityManager();
	    
	    em.getTransaction().begin();
	    Customer customer = em.find(Customer.class, 1L);
	    Order order = new Order();
	    order.setCustomer(customer);
	    order.setRegDate(LocalDateTime.now());
	    order.setStatus(Status.ACTIVE);
	    em.persist(order);
	    for(int c = 0; c<10; c++) {
	    	OrderLine line = new OrderLine();
	    	//line.setProduct("Product "+(c+1));
	    	line.setQuantity(c+1d);
	    	line.setUnitPrice((c+1)*10d);
	    	order.addLines(line);
	    	em.persist(line);
	    	
	    	
	    }
	    Order order2 = em.find(Order.class, 1L);
	    
	    order2.getLines();
	    
	    em.getTransaction().commit();

	}

}
