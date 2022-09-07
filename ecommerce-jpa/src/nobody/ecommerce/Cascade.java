package nobody.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import nobody.ecommerce.entity.Customer;
import nobody.ecommerce.entity.Order;
import nobody.ecommerce.entity.OrderLine;
import nobody.ecommerce.entity.Payment;
import nobody.ecommerce.entity.Product;
import nobody.ecommerce.entity.enums.Paymethod;

public class Cascade {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
	    EntityManager em = entityManagerFactory.createEntityManager();
	    Payment payment = new Payment();
	    payment.setAmount(100d);
	    payment.setPayMethod(Paymethod.CASH);
	    
	    Customer customer1 = em.find(Customer.class, 1);
	    Order order = new Order();
	    
	    order.setCustomer(customer1);
	    order.setPayment(payment);
	    Product product = em.find(Product.class,1L);
	    for(int i = 0; i<10;i++) {
	    	OrderLine line = new OrderLine();
	    	line.setProduct(product);
	    	
	    }
	    
	    
	   
	    
	}

}
