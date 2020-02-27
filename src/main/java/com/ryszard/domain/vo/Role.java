package com.ryszard.domain.vo;

import java.util.Objects;

public class Role {
    private int roleId;

    private int userId;

    private String roleName;

    public Role() {
    }

    public Role(int roleId, int userId, String roleName) {
        this.roleId = roleId;
        this.userId = userId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
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
