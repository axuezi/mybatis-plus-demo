package com.space.common.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.space.common.tenants.TenantProperties;
import com.space.common.config.MyBatisPlusConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 多租户
 *
 * @author axue
 */
@Slf4j
@Component
@Configuration
@AllArgsConstructor
@AutoConfigureBefore(MyBatisPlusConfig.class)
@EnableConfigurationProperties(TenantProperties.class)
public class MechanismHandler {

    private final TenantProperties tenantProperties;

    @Bean
    public TenantLineInnerInterceptor tenantLineInnerInterceptor() {
        return new TenantLineInnerInterceptor(new TenantLineHandler() {
            /**
             * 获取租户ID
             */
            @Override
            public Expression getTenantId() {
                // 可以通过过滤器从请求中获取对应租户id
                String tenantId = "123456";
                log.debug("当前租户为{}", tenantId);
                return new StringValue(tenantId);
            }

            /**
             * 获取多租户的字段名
             * @return String
             */
            @Override
            public String getTenantIdColumn() {
                return tenantProperties.getColumn();
            }

            /**
             * 过滤不需要根据租户隔离的表
             * 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
             * @param tableName 表名
             */
            @Override
            public boolean ignoreTable(String tableName) {
                return tenantProperties.getIgnoreTables().stream()
                        .anyMatch((t) -> t.equalsIgnoreCase(tableName));
            }
        });
    }
}
