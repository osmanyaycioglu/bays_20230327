package com.training.spring.bays.conf;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.training.spring.bays.employee.rest.models.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "app.prop")
public class AppProperties {

    private String                name;
    private String                language;
    private int                   executeTimeout = 200;
    private String                languagePrefix;
    private Employee              employeeTemplate;
    private List<String>          locations;
    private List<Employee>        employees;
    private Map<String, Employee> employeeMap;

}
