# job4j_accidents

В проекте "job4j_accidents" сайт по контролю автомобильных нарушений - Автонарушители.

Функционал проекта позволяет:

* регистрироваться в системе;
* входить в систему;
* просматривать все инциденты;
* подробный просмотр одного инцидента;
* добавлять инциденты.

### Стек технологий :technologist:.
Основные :man_technologist::
- Java 17
- Spring Boot 2.7.3
- Spring Security
- Spring Data 2.7.3 (основной)
- Spring JDBC 5.3.22 (рассмотрен в учебных целях)
- Hibernate 5.6.11.Final (рассмотрен в учебных целях)
- Thymeleaf
- Bootstrap CSS 5+
- Liquibase 4.15.0
- PostgreSQL 15.1 (драйвер JDBC 42.5.1)
- checkstyle 10.0.

Тестирование :mechanic::
- H2database 2.1.214
- Spring boot starter test (JUnit 5 + AssertJ, Mockito)
- Spring Security Test.

### Требования к окружению :black_circle:.
- Java 17
- Maven 3.8
- PostgreSQL 15.

### Запуск проекта :running:.
```Скачать проект job4j_accidents в IntelliJ Idea```

```Создать БД "accidents" (с помощью pgAdmin4)```

```Cоздайте и заполните таблицы БД  "accidents". Откройте закладку Maven -> plugins -> liquibase. Найдите задачу liquibase:update и выполните ее.```

```Запустите приложение в классе Main (ru/job4j/accidents/Main.java)```

```Откройте страницу http://localhost:8080/ в браузере```

### Screenshots работы с приложением по продаже автомобилей :Cars sale:.

- [x] Страница логина

  ![](https://github.com/PavelValger/job4j_accidents/blob/master/img/1%20логин.jpg?raw=true)

- [x] Ошибка логина

  ![](https://github.com/PavelValger/job4j_accidents/blob/master/img/2%20ошибка%20логина.jpg?raw=true)

- [x] Страница регистрации с выводом ошибки существующего пользователя

  ![](https://github.com/PavelValger/job4j_accidents/blob/master/img/3%20регистр.jpg?raw=true)

- [x] Список инцидентов

  ![](https://github.com/PavelValger/job4j_accidents/blob/master/img/4%20список.jpg?raw=true)

- [x] Страница редактирования инцидента

  ![](https://github.com/PavelValger/job4j_accidents/blob/master/img/5%20редакт.jpg?raw=true)

- [x] Страница добавления инцидента

  ![](https://github.com/PavelValger/job4j_accidents/blob/master/img/6%20добавить.jpg?raw=true)


#### Контакты для связи :iphone::
* Вальгер Павел Иванович;
* +79920045094 telegram, whatsapp;
* pavelwalker@mail.ru.