package cybersoft.javabackend.java18.gira.role.repository;

import cybersoft.javabackend.java18.gira.common.repository.BaseRepository;
import cybersoft.javabackend.java18.gira.role.model.UserGroup;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserGroupRepository extends BaseRepository<UserGroup> {
    Optional<UserGroup> findByCode(String code);

    @Query("select ug from UserGroup ug left join fetch ug.users")
    List<UserGroup> findAllWithUsers();
}
