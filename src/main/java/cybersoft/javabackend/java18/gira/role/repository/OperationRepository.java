package cybersoft.javabackend.java18.gira.role.repository;

import cybersoft.javabackend.java18.gira.role.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationRepository extends JpaRepository<Operation, UUID> {
}
