# language: ru

@db
Функционал: Проверка базаового функционала сервиса

  @get_user
  Сценарий: Получение пользователя из БД
    * в БД пользователь добовляет пользователя c id 2
    * в БД пользователь получает пользователя c id 2
