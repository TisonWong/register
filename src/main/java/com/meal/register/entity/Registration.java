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
     * 人员ID
     */
    private Long memberId;

    /**
     * 就餐日期
     */
    private LocalDateTime dinnerDate;

    /**
     * 登记日期
     */
    private LocalDateTime registerDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    private Integer deleted;


}
