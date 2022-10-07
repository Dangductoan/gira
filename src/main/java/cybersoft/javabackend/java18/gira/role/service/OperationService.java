package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.GenericService;
import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.repository.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

public interface OperationService extends GenericService<Operation, OperationDTO, UUID> {
}
@Service
@Transactional
class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;
    private final GiraMapper giraMapper;

    OperationServiceImpl(OperationRepository operationRepository, ModelMapper modelMapper, GiraMapper giraMapper) {
        this.operationRepository = operationRepository;
        this.giraMapper = giraMapper;
    }

    @Override
    public JpaRepository<Operation, UUID> getRepository() {
        return this.operationRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }
}

