package com.meal.register.entity.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * <p>
 * 月记录查询实体类
 * </p>
 *
 * @author Tison
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode()
@TableName("registration")
public class RegistrationDto {

    private static final long serialVersionUID = 1L;

    private Long registerId;

    /**
     * 用户名
     */
    private String memberName;

    /**
     * 就餐月份
     */
    @DateTimeFormat(pattern = "yyyy-MM")
    private LocalDate dinnerMonth;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 就餐次数
     */
    private Integer dinnerCount;

}
