package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = RoleEntity.Operation.TABLE_NAME)



public class Operation extends BaseEntity {
    @Column(name = RoleEntity.Operation.NAME)
    @Length(min = 5,max = 100,message = "Role name must have length between {min} and {max}")
    private String name;

    @Column(name = RoleEntity.Operation.DESCRIPTION)
    @NotBlank
    private String description;

    @Column(name = RoleEntity.Operation.TYPE)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = RoleEntity.RoleMappedOperation.OPERATION_MAPPED_ROLE )
    private Set<Role> roles = new LinkedHashSet<>();
    public enum Type {
        SAVE_OR_UPDATE,
        FETCH,
        REMOVE
    }
}
