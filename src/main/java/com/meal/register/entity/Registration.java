package com.meal.register.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 登记记录表
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Data
@EqualsAndHashCode()
public class Registration {

    private static final long serialVersionUID = 1L;

    @TableId(value = "register_id", type = IdType.AUTO)
    private Long registerId;

    /**
     * 用户名
     */
    private String memberName;

    /**
     * 就餐日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dinnerDate;

    /**
     * 部门ID
     */
    private String departmentName;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    private Integer deleted;


}
