package com.example.hanyan.hanee.service;

import com.example.hanyan.hanee.entity.UserRoles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vigo
 * @since 2021-04-07
 */
public interface IUserRolesService extends IService<UserRoles> {

    /**
     * 查询用户角色信息
     * @param userId 用户ID
     * @return 用户角色关联
     */
    List<UserRoles> getUserRoles(Long userId);

    /**
     * 新增用户角色信息
     * @param userId 用户ID
     * @param roleId 角色ID
     */
    void saveUserRole(Long userId, Long roleId);
}
