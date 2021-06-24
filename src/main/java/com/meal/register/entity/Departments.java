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
 * 部门表
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Data
@EqualsAndHashCode()
public class Departments {

    private static final long serialVersionUID = 1L;

    @TableId(value = "department_id", type = IdType.AUTO)
    private Long departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createDate;

    /**
     * 更新日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    /**
     * 是否已经删除
     */
    private Integer deleted;


}
