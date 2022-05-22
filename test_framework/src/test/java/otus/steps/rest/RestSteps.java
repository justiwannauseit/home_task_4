package otus.steps.rest;


import io.cucumber.java.ru.Если;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import otus.core.apiClient.HttpClient;
import otus.core.apiConfig.BaseConfig;
import otus.core.exceptions.NoSuchParametersForCucumberStep;
import otus.core.pojo.UserJson;

public class RestSteps {

    private Response response;

    @Если("пользователь отправляет запрос на добавление случайного пользователя")
    public void addUserViaRequest() {
        response = HttpClient.doGetRequest(BaseConfig.USER_ADD_URL + "random");
        response.prettyPrint();
    }

    @Если("пользователь проверяет, что код ответа {int}")
    public void checkStatusCode(int expectedCode) {
        Assertions.assertEquals(expectedCode, response.statusCode(), "Статус код сообщения отличается от ожидаемого");
    }

    @Если("пользователь отправляет запрос на получение пользователя")
    public void getUserViaRequest() {
        response = HttpClient.doGetRequest(BaseConfig.USER_GET_URL + HttpClient.convert(response, UserJson.class).getId());
        response.prettyPrint();
    }

    @Если("^пользователь отправляет запрос на получение всех (пользователей|оценок|курсов)$")
    public void getAllInfoViaRequest(String type) throws NoSuchParametersForCucumberStep {
        String path = "";
        switch (type) {
            case "пользователей":
                path = BaseConfig.USER_GET_URL;
                break;
            case "оценок":
                path = BaseConfig.PERFORMANCE_GET_URL;
                break;
            case "курсов":
                path = BaseConfig.COURSE_GET_URL;
                break;
            default:
                throw new NoSuchParametersForCucumberStep(type);
        }
        HttpClient.doGetRequest(path + "all");
        response.prettyPrint();
    }

}
