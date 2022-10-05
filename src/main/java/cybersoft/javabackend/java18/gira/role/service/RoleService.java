package cybersoft.javabackend.java18.gira.role.service;


import cybersoft.javabackend.java18.gira.common.service.GenericService;
import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface RoleService extends GenericService<Role, RoleDTO, UUID> {


    Role update(Role role,String code);
    void deleteByCode(String code);
    RoleDTO save(RoleDTO roleDTO);
}
@Service
@Transactional
class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final GiraMapper mapper;
    //Reflection
    static {
        System.out.println("hello jvm");
    }

    RoleServiceImpl(RoleRepository roleRepository, GiraMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }


    @Override
    public JpaRepository<Role, UUID> getRepository() {
        return this.roleRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    @Override
    public Role update(Role role, String code) {
        return null;
    }

    @Override
    public void deleteByCode(String code) {
        roleRepository.deleteByCode(code);

    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        Role model = mapper.map(roleDTO,Role.class);
        Role saveModel = roleRepository.save(model);
        return mapper.map(saveModel,RoleDTO.class);
    }
}
