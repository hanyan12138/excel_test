package com.example.hanyan.service;

import com.example.hanyan.hanee.dto.request.UserInfoAddVO;
import com.example.hanyan.hanee.entity.User;
import com.example.hanyan.hanee.service.IUserRolesService;
import com.example.hanyan.hanee.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vigo.xian
 */
@Service
public class UserService implements UserDetailsService {

    @Resource
    private IUserService iUserService;

    @Resource
    private IUserRolesService iUserRolesService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserService.findUserById(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

    public void saveUserRole(UserInfoAddVO userInfoAddVO){
        User user = new User();
        user.setUsername(userInfoAddVO.getUsername());
        user.setPassword(passwordEncoder.encode(userInfoAddVO.getPassword()));
        user.setAccountNonExpired(Boolean.TRUE);
        user.setAccountNonLocked(Boolean.TRUE);
        user.setEnabled(Boolean.TRUE);
        user.setCredentialsNonExpired(Boolean.TRUE);
        user = iUserService.saveUserInfo(user);
        iUserRolesService.saveUserRole(user.getId(), userInfoAddVO.getRoleId());
    }
}
