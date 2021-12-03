package com.space.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础类
 *
 * @author axue
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 雪花算法
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 机构编码（用于多租户）
     */
    private String spCode;

    /**
     * 版本（用于乐观锁，后期考虑）
     */
    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 是否删除：0-未删除；1-已删除
     */
    @TableField(value = "is_deleted")
    @TableLogic
    private Boolean deleted;

}