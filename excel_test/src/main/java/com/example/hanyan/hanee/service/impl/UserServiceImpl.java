package com.example.hanyan.hanee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hanyan.hanee.entity.Role;
import com.example.hanyan.hanee.entity.User;
import com.example.hanyan.hanee.entity.UserRoles;
import com.example.hanyan.hanee.mapper.UserMapper;
import com.example.hanyan.hanee.service.IRoleService;
import com.example.hanyan.hanee.service.IUserRolesService;
import com.example.hanyan.hanee.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vigo
 * @since 2021-04-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private IUserRolesService iUserRolesService;

    @Resource
    private IRoleService iRoleService;

    @Override
    public User findUserById(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        List<UserRoles> userRolesList  = iUserRolesService.getUserRoles(user.getId());
        List<Long> rolesId = userRolesList.stream().map(userRoles -> userRoles.getTRolesId()).collect(Collectors.toList());
        List<Role> roleList = iRoleService.getUserRoles(rolesId);
        user.setRoles(roleList);
        return user;
    }

    @Override
    public User saveUserInfo(User userInfo) {
        userMapper.insert(userInfo);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userInfo.getUsername());
        return userMapper.selectOne(queryWrapper);
    }
}
