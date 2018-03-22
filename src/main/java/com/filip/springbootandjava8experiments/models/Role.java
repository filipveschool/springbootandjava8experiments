package com.filip.springbootandjava8experiments.models;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "Roles")
  private Collection<User> users;

  @ManyToMany
  @JoinTable(name = "Roles_Privileges",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "ID"))
  private Set<Privilege> privileges;

  public Role() {

  }

  public Role(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }

  public Set<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(
      Set<Privilege> privileges) {
    this.privileges = privileges;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(id, role.id) &&
        Objects.equals(name, role.name) &&
        Objects.equals(users, role.users) &&
        Objects.equals(privileges, role.privileges);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, users, privileges);
  }
}
