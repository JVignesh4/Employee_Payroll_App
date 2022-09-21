package com.blz.employeepayrollapp.controller;


import com.blz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    //localhost:8090/employeepayrollservice/get
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    //localhost:8090/employeepayrollservice/get/1
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Get Call Success for id: " + empId, HttpStatus.OK);
    }

    //localhost:8090/employeepayrollservice/create
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        return new ResponseEntity<String>("Created Employee Payroll Data for: " + empPayrollDTO, HttpStatus.OK);
    }

    //localhost:8090/employeepayrollservice/update
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        return new ResponseEntity<String>("Updated Employee Payroll Data for: " + empPayrollDTO, HttpStatus.OK);
    }

    //localhost:8090/employeepayrollservice/delete/1
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Delete Call Success for id: " + empId, HttpStatus.OK);

    }
}

