package com.space;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.space.entity.Department;
import com.space.service.IDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@SpringBootTest
public class UnitTest {

    @Resource
    IDepartmentService departmentService;

    @Test
    public void page() {
        Page<Department> page = departmentService.page(new Page<>(1, 10));
        log.info("{}", page);
    }

    @Test
    public void list() {
        List<Department> list = departmentService.list();
        log.info("{}", list);
    }

    @Test
    public void save() {
        Department department = new Department();
        department.setName("总裁办公组");
        departmentService.save(department);
    }

    @Test
    public void update() {
        Department department = departmentService.getById(1383243012468916226L);
        department.setName("总裁办公组");
        departmentService.updateById(department);
    }

    @Test
    public void delete() {
        LambdaQueryWrapper<Department> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Department::getId, "1383243012468916226");
        departmentService.remove(wrapper);
    }

}
