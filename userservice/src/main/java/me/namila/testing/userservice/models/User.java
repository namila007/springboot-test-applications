package me.namila.testing.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.namila.testing.userservice.constants.enums.UserRoles;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.UUID;

import static me.namila.testing.userservice.constants.enums.UserRoles.ADMIN;

/**
 * The type User.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "uuid-char")
  @Column(
          name = "id",
          columnDefinition = "VARCHAR(255)",
          insertable = false,
          updatable = false,
          nullable = false)
  private UUID id;

  @NotNull
  @Column(name = "username", unique = true)
  private String userName;

  @Email
  @NotNull
  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "firstname")
  @Size(min = 1)
  private String firstName;

  @Column(name = "lastname")
  @Size(min = 1)
  private String lastname;

  @NotNull
  @Column(name = "password")
  private String password;

  @NotNull
  @Column(name = "role")
  private UserRoles userRoles;

  @CreationTimestamp
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "created_at")
  private LocalTime createdAt;

  @UpdateTimestamp
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "updated_at")
  private LocalTime updatedAt;

  @Override
  public String toString() {
    return "UserModel{"
            + "id="
            + id
            + ", userName='"
            + userName
            + '\''
            + ", email='"
            + email
            + '\''
            + ", firstName='"
            + firstName
            + '\''
            + ", lastname='"
            + lastname
            + '\''
            + ", password='"
            + password
            + '\''
            + ", userRoles="
            + userRoles
            + ", createdAt="
            + createdAt
            + ", updatedAt="
            + updatedAt
            + '}';
  }

  /**
   * Is admin boolean.
   *
   * @return the boolean
   */
  public boolean isAdmin() {
    return this.userRoles.equals(ADMIN);
  }
}
