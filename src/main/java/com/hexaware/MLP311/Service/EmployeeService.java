package com.hexaware.MLP311.Service;

import java.util.List;
import java.util.ArrayList;

import com.hexaware.MLP311.model.Employee;

public class EmployeeService {
    public Employee getById(List< Employee> list, final int empId)
    {
        for(Employee e : list) {
            if(e.getEmpId() == empId) {
                return e;
            }
        }
        return null;
    }
    List<Employee> list = new ArrayList<Employee>();

    public List<Employee > employeeList(List<Employee> list ,Employee e)
    {
        list.add(e);
        return list;
    }
}
