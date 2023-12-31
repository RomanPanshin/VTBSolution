# TechTime - MORE.Tech 5.0 project
## Описание

### Приложение создано с целью помочь пользователю выбрать подходящее отделение банка ВТБ. 
### Реализует следующий функционал:
* Определение местоположения пользователя
* Отображение банкоматов и отделений со стилистикой, зависящей от нагруженности
* Отображение полной информации о выбранном отделении \ банкомате
* Возможность проложить маршрут до отделения \ банкомата и получить метаданные маршрута
* Переключение между маршрутами
* Добавление события посещения в календарь пользователя
* Сбор обратной связи об отделении \ банкомате

### О программной составляющей
* Язык разработки: Kotlin
* В качестве архитектурного паттерна используется MVVM, как функционально достаточная масштабируемая и актуальная система
* Для работы с API используется библиотека Retrofit
* Для работы с картами используется Yandex MapKit
* Для взаимодействия view<->viewmodel используется LiveData

### О серверной части
* Для backend-части используется Spring Boot. 
  - Для запуска сервера на Spring Boot в папке `VTB`, выполните следующую команду:
    ```bash
    ./mvnw spring-boot:run
    ```

  - Для запуска сервера через docker-compose:
    ```bash
    docker-compose build
    docker-compose up
    ```
API будет доступно по адресу: http://localhost:60103

Документация к API находится по адресу: http://localhost:60103/docs http://localhost:8080/swagger-ui/index.html#/


## Скриншоты
<img src="https://github.com/alexp0111/VTBDepSel/assets/62151474/daaf1d78-7e20-4054-9045-2f2e5766d385" width="250"/>
<img src="https://github.com/alexp0111/VTBDepSel/assets/62151474/39d793fc-9577-4a7b-b7eb-c2e254d975e3" width="250"/>
<img src="https://github.com/alexp0111/VTBDepSel/assets/62151474/39cb9b93-2ac0-439b-b5ef-fe6b60e746e9" width="250"/>
<img src="https://github.com/alexp0111/VTBDepSel/assets/62151474/60d8ce23-4da8-46da-aeb8-f4dcfddcacfd" width="250"/>
<img src="https://github.com/alexp0111/VTBDepSel/assets/62151474/d00a0c8e-7fb2-49aa-8459-d0bff088a4f5" width="250"/>
<img src="https://github.com/alexp0111/VTBDepSel/assets/62151474/13afafb4-49dd-4416-b3dc-a9355e4006bb" width="250"/>

## Требования к устройству для запуска
* MIN SDK: 26
* Gradle JDK: 11
* Разрешение на отслеживание геопозиции
