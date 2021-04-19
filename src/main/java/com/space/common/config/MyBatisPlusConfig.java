package com.space.common.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.space.common.handler.AutoFieldFillHandler;
import com.space.common.tenants.TenantProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * mybatis-plus 配置
 *
 * @author axue
 */
@Slf4j
@Configuration
@AllArgsConstructor
@EnableTransactionManagement
public class MyBatisPlusConfig {

    @Resource
    private final TenantProperties tenantProperties;

    @Resource
    private final TenantLineInnerInterceptor tenantLineInnerInterceptor;

    /**
     * 单页分页条数限制(默认无限制,参见 插件#handlerLimit 方法)
     */
    private static final Long MAX_LIMIT = 1000L;

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        boolean enableTenant = tenantProperties.getEnable();
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 多租户
        if (enableTenant) {
            interceptor.addInnerInterceptor(tenantLineInnerInterceptor);
        }
        // 分页插件: PaginationInnerInterceptor
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setMaxLimit(MAX_LIMIT);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        // 乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 防止全表更新与删除插件: BlockAttackInnerInterceptor
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

    /**
     * 自动填充数据
     */
    @Bean
    @ConditionalOnMissingBean(AutoFieldFillHandler.class)
    public AutoFieldFillHandler autoFieldFillHandler() {
        AutoFieldFillHandler autoFieldFillHandler = new AutoFieldFillHandler();
        log.info("AutoFieldFillHandler [{}]", autoFieldFillHandler);
        return autoFieldFillHandler;
    }

}
