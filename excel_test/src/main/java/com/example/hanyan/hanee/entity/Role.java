package com.example.hanyan.hanee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.hanyan.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author vigo
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_role")
public class Role extends BaseEntity {


    private String name;

    private String nameZh;


}
