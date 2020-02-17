package com.ryszard.domain.vo;

import java.util.Objects;

public class Role {
    private Long roleId;

    private Long userId;

    private String roleName;

    public Role() {
    }

    public Role(Long roleId, Long userId, String roleName) {
        this.roleId = roleId;
        this.userId = userId;
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) &&
                Objects.equals(userId, role.userId) &&
                Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userId, roleName);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
