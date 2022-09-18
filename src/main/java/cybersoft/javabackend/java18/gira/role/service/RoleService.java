package cybersoft.javabackend.java18.gira.role.service;


import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role save(Role role);
    Role update(Role role,String code);
    void delete(String code);
}
@Service
@Transactional
class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role, String code) {
        Role curRole = roleRepository.findByCode(code);
        curRole.setName(role.getName());
        curRole.setDescription(role.getDescription());
        return roleRepository.save(curRole);
    }

    @Override
    public void delete(String code) {
        roleRepository.deleteByCode(code);

    }
}
