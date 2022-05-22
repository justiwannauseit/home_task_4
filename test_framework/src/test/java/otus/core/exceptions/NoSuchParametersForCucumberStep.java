package otus.core.exceptions;

public class NoSuchParametersForCucumberStep extends Exception {

    public NoSuchParametersForCucumberStep(String message) {
        super("Не найдена реализация шага с параметром: " + message);
    }
}
