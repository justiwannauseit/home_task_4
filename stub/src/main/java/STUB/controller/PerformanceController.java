package STUB.controller;

import STUB.dao.Performance;
import STUB.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceRepository performanceRepository;

    @GetMapping("/get/{id}")
    public Performance getCourseById(@PathVariable long id) {
        return performanceRepository.getById(id);
    }

    @GetMapping("/get/all")
    public List<Performance> getAllUser() {
        return performanceRepository.getAllPerformances();
    }

}
