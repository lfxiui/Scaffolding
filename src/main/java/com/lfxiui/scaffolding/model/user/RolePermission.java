package com.lfxiui.scaffolding.model.user;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "role_permission")
public class RolePermission {
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "permission_id")
    private Long permissionId;

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}