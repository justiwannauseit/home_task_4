package STUB.repository;

import STUB.dao.Performance;
import STUB.repository.crudInterface.PerformanceRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class PerformanceRepository {

    @Autowired
    private PerformanceRepositoryCrud performanceRepositoryCrud;


    public Performance getById(final long id) {
        return performanceRepositoryCrud.findById(id).get();
    }

    public List<Performance> getAllPerformances() {
        return StreamSupport.stream(performanceRepositoryCrud.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
