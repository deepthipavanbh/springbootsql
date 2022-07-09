package com.pavan.springbootsql.service;

import com.pavan.springbootsql.entity.Department;
import com.pavan.springbootsql.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Pune")
                .departmentCode("It-06")
                .departmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);

    }

         @Test
         @DisplayName("Get data based on valid Department Name" )
       public void whenValidDepartmentNameThenDepartmentShouldFound(){

            String  departmentName="IT";
             Department found=departmentService.fetchDepartmentByName(departmentName);

             assertEquals(departmentName,found.getDepartmentName());
       }
}