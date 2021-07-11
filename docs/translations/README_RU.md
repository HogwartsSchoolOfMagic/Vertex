<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <h1>
        <a href="https://funprojectsforsoul.github.io/Vertex/">Vertex</a>
    </h1>
</div>

<div align="center">
    <a href="https://github.com/FunProjectsForSoul/Vertex/blob/master/docs/README.md">
        <img alt="english-version" src="https://raw.githubusercontent.com/FunProjectsForSoul/Vertex/master/assets/languages/english.png"/>
    </a>
</div>

<div align="center">
    <img src="https://img.shields.io/github/last-commit/FunProjectsForSoul/Vertex" height="25" alt="last-commit" />
    <img src="https://img.shields.io/github/v/release/FunProjectsForSoul/Vertex" height="25" alt="last-release" />
    <img src="https://tokei.rs/b1/github/FunProjectsForSoul/Vertex?category=code" height="25" alt="code-lines" />
    <img src="https://sonarcloud.io/api/project_badges/measure?project=FunProjectsForSoul_Vertex&metric=bugs" height="25" alt="sonar-cloud-bugs" />
    <img src="https://github.com/FunProjectsForSoul/Vertex/actions/workflows/check-style.yml/badge.svg" height="25" alt="checking-style" />
    <img src="https://github.com/FunProjectsForSoul/Vertex/actions/workflows/sonar.yml/badge.svg" height="25" alt="checking-sonar" />
    <img src="https://github.com/FunProjectsForSoul/Vertex/actions/workflows/build.yml/badge.svg" height="25" alt="build" />
</div>

### 📖 Описание
___

Настольное приложение для случайного обновления отображаемого числа от 0 до 100. Можно обновлять число по таймеру с 
интервалом: 1 секунда или 1,5 секунды.

### ❗ Требования
___

* **JDK**: 8 или выше;
* **Сконфигурированная переменная окружения**: JAVA_HOME.

### 📋 Инструкция по запуску проекта
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

```java
public class VertexApplication {

  public static void main(String[] args) { // Используетс для запуска приложения.
    Runnable runnable = VertexUtil::started;
    invokeLater(runnable);
  }
}
```

### 💻 Интерфейс приложения
___
<div align="center">
   <img src="https://raw.githubusercontent.com/FunProjectsForSoul/Vertex/master/assets/vertex-form.gif" alt="gui-interface" />
</div>

<div align="center">
   <img src="https://raw.githubusercontent.com/FunProjectsForSoul/Vertex/master/assets/vertex-form-popup-menu.png" alt="gui-interface" />
</div>

### 🎫 Лицензия
___

**[Creative Commons Legal Code](https://github.com/Bangerok/Vertex/blob/master/LICENSE)**

_Copyright ©2021, Vladislav [[Bangerok]](https://github.com/Bangerok) Kuznetsov_