<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <h1>
        <a href="https://funprojectsforsoul.github.io/Vertex/">Проект Vertex</a>
    </h1>
</div>

<div align="center">
    <a href="https://github.com/Bangerok">
        <img alt="english-version" src="https://raw.githubusercontent.com/Bangerok/Bangerok/master/assets/contacts/github.svg"/>
    </a>
</div>

<div align="center">
    <img src="https://sonarcloud.io/api/project_badges/measure?project=FunProjectsForSoul_Vertex&metric=bugs" height="25" alt="sonar-cloud-bugs" />
    <img src="https://github.com/FunProjectsForSoul/Vertex/actions/workflows/check-style.yml/badge.svg" height="25" alt="checking-style" />
    <img src="https://github.com/FunProjectsForSoul/Vertex/actions/workflows/sonar.yml/badge.svg" height="25" alt="checking-sonar" />
    <img src="https://github.com/FunProjectsForSoul/Vertex/actions/workflows/build.yml/badge.svg" height="25" alt="build" />
</div>

### Описание
___

Настольное приложение для случайного обновления отображаемого числа от 0 до 100. Можно обновлять число по таймеру с 
интервалом: 1 секунда или 1,5 секунды.

### Требования
___

* **JDK**: 8 или выше;
* **Сконфигурированная переменная окружения**: JAVA_HOME.

### Инструкция по запуску проекта
___

*Все команды выполняются в консоли.*
1. Создать папку: `mkdir GitProjects`;
2. Перейти в нее: `cd GitProjects`;
3. Клонировать код репозитория: `git clone https://github.com/FunProjectsForSoul/Vertex.git`;
4. Перейти в созданную папку: `cd Vertex`;
5. Собрать проект: `mvn clean install`;
6. После выполнения 5 пункта — будет создана папка с именем **“target”**. Переходим в нее: `go target`;
7. Внутри будет находиться файл **“vertex-0.2.2.jar”**.
Запускаем его командой: `java -jar vertex-0.2.2.jar`;
8. Запустится приложение.

**Бонус**: вместо 7 пункта можно действовать иначе.
В папке — **target**, также есть файл: **vertex.exe**, который можно просто запустить.
Если возникнут проблемы — пиши мне.

### Интерфейс приложения
___
<div align="center">

![VertexForm](../assets/vertex-form.gif)
</div>

<div align="center">

![VertexFormPopupMenu](../assets/vertex-form-popup-menu.png)
</div>

### Лицензия
___

**[Creative Commons Legal Code](https://github.com/Bangerok/Vertex/blob/master/LICENSE)**

_Copyright ©2021, Владислав [[Bangerok]](https://github.com/Bangerok) Кузнецов_