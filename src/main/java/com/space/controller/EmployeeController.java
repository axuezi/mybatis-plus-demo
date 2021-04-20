package com.space.controller;

import com.space.common.enums.ResultCode;
import com.space.common.result.Result;
import com.space.entity.Employee;
import com.space.service.IEmployeeService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 雇员表 前端控制器
 * </p>
 *
 * @author axue
 * @since 2021-04-16
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    IEmployeeService employeeService;

    @GetMapping("get")
    public Result getEmployee(String id) {
        List<Employee> list = employeeService.list();
        if (!StringUtils.hasText(id)) {
            return Result.success(list);
        } else {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }
    }

}
