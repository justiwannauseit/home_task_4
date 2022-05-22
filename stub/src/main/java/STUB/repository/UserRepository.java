package STUB.repository;

import STUB.dao.User;
import STUB.repository.crudInterface.UserRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepository {

    @Autowired
    private UserRepositoryCrud userRepositoryCrud;


    public User add(final User user) {
        return userRepositoryCrud.save(user);
    }


    public User getById(final long id) {
        return userRepositoryCrud.findById(id).get();
    }


    public List<User> getAllUsers() {
        return StreamSupport.stream(userRepositoryCrud.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
