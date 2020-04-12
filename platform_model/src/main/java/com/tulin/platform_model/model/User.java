package com.tulin.platform_model.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User extends BaseEntity {
    @TableField(value = "nick_name")
    private String nickName;
    @TableField(value = "real_name")
    private String realName;
    @TableField(value = "role_id")
    private String roleId;
    @TableField(value = "tel")
    private String tel;
}
