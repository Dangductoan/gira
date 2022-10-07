package cybersoft.javabackend.java18.gira.user.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import cybersoft.javabackend.java18.gira.role.model.RoleEntity;
import cybersoft.javabackend.java18.gira.role.model.UserGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = UserEntity.User.TABLE_NAME)
public class User extends BaseEntity {
    @Column(name=UserEntity.User.USERNAME
    ,nullable = false
    ,unique = true
    ,updatable = false
    ,length = 100
    )
    private String username;

    @Column(name=UserEntity.User.PASSWORD
            ,nullable = false
            ,unique = true
            ,updatable = false
    )
    private String password;
    @Column(name=UserEntity.User.EMAIL)
    private String email;

    @Column(name=UserEntity.User.DISPLAY_NAME)
    private String displayName;

    @Column(name=UserEntity.User.FULLNAME)
    private String fullname;

    @Column(name=UserEntity.User.AVATAR)
    private String avatar;

    @Column(name=UserEntity.User.STATUS)
    private Status status;

    @Column(name = UserEntity.User.FACEBOOK_URL)
    private String facebookUrl;

    @Column(name=UserEntity.User.MAJORITY)
    private String majority;

    @Column(name=UserEntity.User.DEPARTMENT)
    private String department;

    @Column(name=UserEntity.User.HOBBY)
    private String hobbies;

    @ManyToMany(mappedBy = "users")
    private Set<UserGroup> userGroups = new LinkedHashSet<>();
    public enum Status {
        ACTIVE,
        TEMPORARY_BLOCKED,
        PERMANENT_BLOCKED

    }
}
