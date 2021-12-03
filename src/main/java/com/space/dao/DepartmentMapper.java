package com.space.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.space.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author axue
 * @since 2021-04-16
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    IPage<Department> queryPage(IPage page);
}
