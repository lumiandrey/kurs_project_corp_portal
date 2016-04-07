package by.bsuir.ief.rest.controller;

/**
 * Created by Raiton on 31.03.2016.
 */

import by.bsuir.ief.rest.model.entity.Employee;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Handles requests for the Employee service.
 */
@RestController
public class EmployeeController {

    static final Logger logger = Logger.getLogger(EmployeeController.class);

    //Map to store employees, ideally we should use database
    Map<Integer, Employee> empData = new HashMap<>();

    @RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
    public @ResponseBody Employee getDummyEmployee() {
        Employee emp = new Employee();
        emp.setId(9999);
        emp.setName("Dummy");
        emp.setCreatedDate(new Date());
        empData.put(9999, emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
    public Employee getEmployee( int id) {

        return empData.get(id);
    }

    @RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        List<Employee> emps = new ArrayList<Employee>();
        Set<Integer> empIdKeys = empData.keySet();
        for(Integer i : empIdKeys){
            emps.add(empData.get(i));
        }
        return emps;
    }

    @RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        emp.setCreatedDate(new Date());
        empData.put(emp.getId(), emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
    public Employee deleteEmployee(@PathVariable("id") int empId) {
        Employee emp = empData.get(empId);
        empData.remove(empId);
        return emp;
    }

}