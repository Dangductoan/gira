package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name=RoleEntity.Module.TABLE_NAME)
public class Module extends BaseEntity {
    @Column(name = RoleEntity.Module.NAME)
    @Length(min = 5,max = 100,message = "Role name must have length between {min} and {max}")
    private String name;

    @Column(name = RoleEntity.Module.CODE)
    @Length(min=3,max=10,message = "Role code must have length between {min} and {max}" )
    private String code;

    @Column(name = RoleEntity.Module.DESCRIPTION)
    @NotBlank
    private String description;
}
