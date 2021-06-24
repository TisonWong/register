package com.meal.register.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Data
@EqualsAndHashCode()
public class Members{

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "member_id", type = IdType.AUTO)
    private Long memberId;

    /**
     * 用户名
     */
    private String memberName;

    /**
     * 用户电话
     */
    private String memberPhone;

    /**
     * 用户邮箱
     */
    private String memberEmail;

    /**
     * 用户身份（admin/user)
     */
    private String memberIdentity;

    /**
     * 用户密码
     */
    private String memberPwd;

    /**
     * 部门ID
     */
    private Long departmentId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    private Integer deleted;


}
