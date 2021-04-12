package com.example.hanyan.hanee.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author vigo.xian
 */
@Data
public class UserInfoAddVO implements Serializable {

    private static final long serialVersionUID = 4856696343700550078L;

    /**
     * 用户名
     * */
    private String username;

    /**
     * 用户密码
     * */
    private String password;

    /**
     * 角色ID
     * */
    private Long roleId;
}
