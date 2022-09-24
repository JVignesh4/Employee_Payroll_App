package com.blz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

    public static void main(String[] args) {
        System.out.println("Welcome To Employee Payroll Application!");
        SpringApplication.run(EmployeePayrollAppApplication.class, args);
        log.info("Employee Payroll App Started");
    }
}
