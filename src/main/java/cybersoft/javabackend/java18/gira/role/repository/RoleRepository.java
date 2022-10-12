package cybersoft.javabackend.java18.gira.role.repository;

import cybersoft.javabackend.java18.gira.common.repository.BaseRepository;
import cybersoft.javabackend.java18.gira.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends BaseRepository<Role> {
    Optional<Role> findByCode(String code);


}
