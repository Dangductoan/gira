package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.GenericService;
import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.UserGroupDTO;
import cybersoft.javabackend.java18.gira.role.dto.UserGroupWithUsersDTO;
import cybersoft.javabackend.java18.gira.role.model.UserGroup;
import cybersoft.javabackend.java18.gira.role.repository.UserGroupRepository;
import cybersoft.javabackend.java18.gira.user.model.User;
import cybersoft.javabackend.java18.gira.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface UserGroupService extends GenericService<UserGroup, UserGroupDTO, UUID> {
    List<UserGroupWithUsersDTO> findAllDtoIncludeUsers();

    UserGroupWithUsersDTO addUsers(UUID userGroupID,List<UUID> ids);
}
@Service
@Transactional
class UserGroupServiceImpl implements UserGroupService {
    private final UserGroupRepository userGroupRepository;
    private final GiraMapper giraMapper;
    private final UserService userService;

    UserGroupServiceImpl(UserGroupRepository userGroupRepository, GiraMapper giraMapper, UserService userService) {
        this.userGroupRepository = userGroupRepository;
        this.giraMapper = giraMapper;
        this.userService = userService;
    }

    @Override
    public JpaRepository<UserGroup, UUID> getRepository() {
        return userGroupRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return giraMapper;
    }

    @Override
    public List<UserGroupWithUsersDTO> findAllDtoIncludeUsers() {
        return userGroupRepository.findAllWithUsers()
                .stream().map(model -> giraMapper.map(model,UserGroupWithUsersDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserGroupWithUsersDTO addUsers(UUID userGroupID, List<UUID> ids) {
        UserGroup userGroup = userGroupRepository.findById(userGroupID)
                .orElseThrow(() -> new ValidationException("UserGroup is not existed."));
        List<User> users = userService.findByIds(ids);
        users.forEach(userGroup::addUser);
        return giraMapper.map(userGroup,UserGroupWithUsersDTO.class);
    }
}