package ru.college.chat.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@NotNull
	private String userName;

	@NotNull
	private String email;

	@NotNull
	private String password;

	private LocalDateTime lastVisit;

	@OneToMany(mappedBy = "fromUser",fetch = FetchType.EAGER)
	private List<Message> messages;

	@OneToMany(mappedBy = "toUser",fetch = FetchType.EAGER)
  private List<Addressee> addressees;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public List<Addressee> getAddressees() {
    return addressees;
  }

  public void setAddressees(List<Addressee> addressees) {
    this.addressees = addressees;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

  public LocalDateTime getLastVisit() {
    return lastVisit;
  }

  public void setLastVisit(LocalDateTime setLastVisit) {
    this.lastVisit = setLastVisit;
  }
}
