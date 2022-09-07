package nobody.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import nobody.ecommerce.entity.enums.Status;

@Entity
@Table(name = "customers")
public class Customer {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "firt_name", length = 30, nullable = false)
  private String firstName;
  @Column(name = "last_name", length = 30, nullable = false)
  private String lastName;
  @Temporal(TemporalType.DATE)
  @Column(name = "birthday", nullable = false)
  private Calendar birthday;
  
  @Column(name = "reg_date", nullable = false, unique = false)
  private LocalDateTime reg_date;
  
  @Column(name = "status", nullable = false, length = 8)
  @Enumerated(EnumType.STRING)
  private Status status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

public Calendar getBirthday() {
	return birthday;
}

public void setBirthday(Calendar birthday) {
	this.birthday = birthday;
}

public Status getStatus() {
	return status;
}

public void setStatus(Status status) {
	this.status = status;
}

  

}
