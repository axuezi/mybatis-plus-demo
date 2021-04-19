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
 * 部门表
 * </p>
 *
 * @author axue
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_department")
@ApiModel(value="Department对象", description="部门表")
public class Department extends BaseEntity {

    @ApiModelProperty(value = "部门名称")
    private String name;

}
