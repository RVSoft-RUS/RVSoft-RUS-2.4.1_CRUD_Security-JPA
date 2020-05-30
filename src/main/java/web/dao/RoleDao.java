package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Role;

public interface RoleDao {
    Role findByName(String name) ;
}
