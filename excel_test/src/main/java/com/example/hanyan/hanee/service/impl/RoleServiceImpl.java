package com.example.hanyan.hanee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hanyan.hanee.entity.Role;
import com.example.hanyan.hanee.entity.User;
import com.example.hanyan.hanee.mapper.RoleMapper;
import com.example.hanyan.hanee.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getUserRoles(List<Long> roleIds) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", roleIds);
        return roleMapper.selectList(queryWrapper);
    }
}
