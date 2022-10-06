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

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name=RoleEntity.UserGroup.TABLE_NAME)
public class UserGroup extends BaseEntity {
    @Column(name = RoleEntity.UserGroup.NAME)
    @Length(min = 5,max = 100,message = "Role name must have length between {min} and {max}")
    private String name;

    @Column(name = RoleEntity.UserGroup.CODE)
    @Length(min=3,max=10,message = "Role code must have length between {min} and {max}" )
    private String code;

    @Column(name = RoleEntity.UserGroup.DESCRIPTION)
    @NotBlank
    private String description;

    @ManyToMany(mappedBy = "userGroups",cascade ={CascadeType.MERGE,CascadeType.PERSIST} )
    private Set<Role> roles = new LinkedHashSet<>();
}
