package cybersoft.javabackend.java18.gira.common.service;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public interface GenericService<T extends BaseEntity,D,I> {
    JpaRepository<T,I> getRepository();//factory method
    ModelMapper getMapper();

    @Transactional(readOnly = true)
    default List<D> findAllDto(Class<D> clazz){
        return getRepository().findAll().stream()
                .map(model -> getMapper().map(model, clazz))
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    default List<D> findAllDto(Pageable page, Class<D> clazz){
        return getRepository().findAll(page).stream()
                .map(model -> getMapper().map(model, clazz))
                .collect(Collectors.toList());
    }
    default Optional<T> findById(I id) {
        return getRepository().findById(id);
    }


    default D save(D dto,Class<T> modelClass,Class<D> dtoClass) {
        T model = getMapper().map(dto,modelClass);
        T saveModel = getRepository().save(model);
        return getMapper().map(saveModel,dtoClass);
    }

    default List<T> findByIds(List<I> ids) {
        return getRepository().findAllById(ids);
    };
}
