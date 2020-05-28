package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @ManyToMany(fetch = FetchType.EAGER) //, cascade = CascadeType.ALL
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;// = new HashSet<>()

    public User() { }

//    public User(String name, String surname, int age) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }
//
//    public User(long id, String name, String surname, int age) {
//        this(name, surname, age);
//        this.id = id;
//    }
//
//    public User(String login, String password, String role, String name, String surname, int age) {
//        this(name, surname, age);
//        this.login = login;
//        this.password = password;
//        this.role = role;
//    }

    public User(String login, String password, String role, String name, String surname, int age, Set<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role = role;
        this.roles = roles;
    }

    public User(long id, String login, String password, String role, String name, String surname, int age, Set<Role> roles) {
        this(login, password, role, name, surname, age, roles);
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getLogin() {
        return login;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getLogin();
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

    public String getRole() {
        return role;
    }


    @Override
    public int hashCode() {
        int result = 31 + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + (age * 131 << 18);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || getClass() != obj.getClass()) return false;

        User other = (User) obj;
        if (!other.name.equals(name)) return false;
        if (!other.surname.equals(surname)) return false;
        if (!(other.age == age)) return false;
        if (!(other.login.equals(login))) return false;
        if (!(other.password.equals(password))) return false;
        return other.role.equals(role);
    }

    @Override
    public String toString() {
        return "User{" +
                name + " " +
                surname + ", " +
                age + " лет}";
    }
}
