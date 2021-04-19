package com.space.common.tenants;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 租户属性
 *
 * @author axue
 */
@Data
@ConfigurationProperties(prefix = "mate.tenant")
public class TenantProperties {

    /**
     * 是否开启租户模式
     */
    private final Boolean enable = true;

    /**
     * 需要排除的多租户的表
     */
    private final List<String> ignoreTables = Collections.singletonList("user");

    /**
     * 多租户字段名称
     */
    private final String column = "sp_code";

    /**
     * 排除不进行租户隔离的sql
     * 样例全路径：vip.mate.system.mapper.UserMapper.findList
     */
    private final List<String> ignoreSqlList = new ArrayList<>();

}
