package com.example.hanyan.hanee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hanyan.hanee.entity.User;
import com.example.hanyan.hanee.entity.UserRoles;
import com.example.hanyan.hanee.mapper.UserRolesMapper;
import com.example.hanyan.hanee.service.IUserRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vigo
 * @since 2021-04-07
 */
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements IUserRolesService {

    @Resource
    private UserRolesMapper userRolesMapper;

    @Override
    public List<UserRoles> getUserRoles(Long userId) {
        QueryWrapper<UserRoles> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t_user_id", userId);
        return userRolesMapper.selectList(queryWrapper);
    }

    @Override
    public void saveUserRole(Long userId, Long roleId) {
        UserRoles userRoles = new UserRoles();
        userRoles.setTUserId(userId);
        userRoles.setTRolesId(roleId);
        userRolesMapper.insert(userRoles);
    }
}
