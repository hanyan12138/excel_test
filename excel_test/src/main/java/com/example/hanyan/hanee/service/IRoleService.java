package com.example.hanyan.hanee.service;

import com.example.hanyan.hanee.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hanyan.hanee.entity.UserRoles;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vigo
 * @since 2021-04-07
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询用户角色信息
     * @param roleIds 角色列表
     * @return 角色列表
     */
    List<Role> getUserRoles(List<Long> roleIds);

}
