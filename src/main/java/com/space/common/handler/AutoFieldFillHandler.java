package com.space.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 需要将自定义填充控制器注册为组件
 *
 * @author axue
 */
@Component
public class AutoFieldFillHandler implements MetaObjectHandler {

    /**
     * 创建时间
     */
    private final static String CRETE_TIME = "createTime";

    /**
     * 创建人
     */
    private final static String CRETE_BY = "createBy";

    /**
     * 修改时间
     */
    private final static String UPDATE_TIME = "updateTime";

    /**
     * 修改人
     */
    private final static String UPDATE_BY = "updateBy";

    /**
     * 用户
     */
    private final static String USER = "axue";

    /**
     * insert操作时要填充的字段
     *
     * @param metaObject Object
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 判断是否存在createTime字段,有的情况下才给它自动填充值
        if (metaObject.hasSetter(CRETE_TIME)) {
            this.strictInsertFill(metaObject, CRETE_TIME, LocalDateTime.class, LocalDateTime.now());
            this.strictInsertFill(metaObject, CRETE_BY, String.class, USER);
        }
    }

    /**
     * update操作时要填充的字段
     *
     * @param metaObject Object
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 判断是否存在updateTime字段,有的情况下才给它自动填充值
        if (metaObject.hasSetter(UPDATE_TIME)) {
            this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
            this.strictUpdateFill(metaObject, UPDATE_BY, String.class, USER);
        }
    }

}
