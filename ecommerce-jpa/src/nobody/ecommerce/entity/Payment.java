package nobody.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import nobody.ecommerce.entity.enums.Paymethod;

@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "fk_order", nullable = false, updatable = false)
	private Order order;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "pay_method", nullable = false)
	private Paymethod payMethod;
	
	@Column(name = "amount", nullable = false)
	private Double amount=0d;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Paymethod getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Paymethod payMethod) {
		this.payMethod = payMethod;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	

}
