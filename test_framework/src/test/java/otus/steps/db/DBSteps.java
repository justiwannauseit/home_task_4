package otus.steps.db;


import io.cucumber.java.ru.Если;
import otus.core.databaseClient.DbClient;
import otus.core.entity.User;


public class DBSteps {

    @Если("^в БД пользователь получает пользователя c id (.*)$")
    public void getUserFromDB(String id) {
        var res = DbClient.getById(User.class, Integer.parseInt(id));
    }

    @Если("^в БД пользователь добовляет пользователя c id (.*)$")
    public void addUserInDB(String id) {
        var user = new User();
        user.setId(Integer.parseInt(id));
        DbClient.insert(user);
    }


}
