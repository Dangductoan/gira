package cybersoft.javabackend.java18.gira.role.service;


import cybersoft.javabackend.java18.gira.common.service.GenericService;
import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.dto.RoleWithOperationsDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

public interface RoleService extends GenericService<Role, RoleDTO, UUID> {


    RoleWithOperationsDTO addOperations(List<UUID> ids, UUID roleId);
}
@Service
@Transactional
class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final GiraMapper mapper;

    private final OperationService operationService;
    //Reflection


    RoleServiceImpl(RoleRepository roleRepository, GiraMapper mapper, OperationService operationService) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.operationService = operationService;
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
    public RoleWithOperationsDTO addOperations(List<UUID> ids, UUID roleId) {
        Role curRole = roleRepository.findById(roleId)
                .orElseThrow( () ->
                        new ValidationException("Role is not existed.")
                );
      List<Operation> operations = operationService.findByIds(ids);
      operations.forEach(curRole::addService);
        return mapper.map(curRole,RoleWithOperationsDTO.class);
    }
}
