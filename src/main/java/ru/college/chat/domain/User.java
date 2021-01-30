package ru.college.chat.domain;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usr")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@NotNull
	private String username;

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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public String getPassword() {
		return password;
	}


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
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
