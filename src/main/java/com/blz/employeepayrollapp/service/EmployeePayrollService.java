package com.blz.employeepayrollapp.service;

import com.blz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.blz.employeepayrollapp.exception.EmployeePayrollException;
import com.blz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found In the List"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollList.size() + 1, empPayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(empPayrollDTO.name);
        employeePayrollData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(empId - 1, employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId - 1);
    }}