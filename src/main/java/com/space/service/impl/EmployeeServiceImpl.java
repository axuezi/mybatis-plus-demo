package com.space.service.impl;

import com.space.entity.Employee;
import com.space.dao.EmployeeMapper;
import com.space.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 雇员表 服务实现类
 * </p>
 *
 * @author axue
 * @since 2021-04-16
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
