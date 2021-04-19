package com.space.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.space.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 雇员表
 * </p>
 *
 * @author axue
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_employee")
@ApiModel(value="Employee对象", description="雇员表")
public class Employee extends BaseEntity {

    @ApiModelProperty(value = "雇员姓名")
    private String employeeName;

    @ApiModelProperty(value = "雇员住址")
    private String address;

    @ApiModelProperty(value = "部门id")
    private Long departmentId;

}
