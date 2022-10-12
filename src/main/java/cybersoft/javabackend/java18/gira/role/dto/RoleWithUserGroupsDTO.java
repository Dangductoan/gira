package cybersoft.javabackend.java18.gira.role.dto;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class RoleWithUserGroupsDTO implements Serializable {
    private UUID id;

    private String name;

    private String code;

    private String description;

    private Set<UserGroupDTO> userGroups = new LinkedHashSet<>();
}
