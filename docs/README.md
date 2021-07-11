<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <h1>
        <a href="https://funprojectsforsoul.github.io/Vertex/">Vertex</a>
    </h1>
</div>

<div align="center">
    <a href="https://github.com/HogwartsSchoolOfMagic/Vertex/blob/master/docs/translations/README_EN.md">
        <img alt="english-version" src="https://raw.githubusercontent.com/HogwartsSchoolOfMagic/Vertex/master/assets/languages/english.png"/>
    </a>
</div>

<div align="center">
    <img src="https://img.shields.io/github/last-commit/HogwartsSchoolOfMagic/Vertex" height="25" alt="last-commit" />
    <a href="https://wakatime.com/@SmithyVL"><img src="https://wakatime.com/badge/github/HogwartsSchoolOfMagic/Vertex.svg" height="25" alt="time-with-code" /></a>
    <a href="https://sonarcloud.io/code?id=HogwartsSchoolOfMagic_Vertex"><img src="https://sonarcloud.io/api/project_badges/measure?project=HogwartsSchoolOfMagic_Vertex&metric=ncloc" height="25" alt="sonar-code-lines" /></a>
    <a href="https://sonarcloud.io/summary/new_code?id=HogwartsSchoolOfMagic_Vertex"><img src="https://sonarcloud.io/api/project_badges/measure?project=HogwartsSchoolOfMagic_Vertex&metric=alert_status" height="25" alt="sonar-quality-gate-status" /></a>
    <a href="https://github.com/HogwartsSchoolOfMagic/Vertex/actions/workflows/ci.yml"><img src="https://github.com/HogwartsSchoolOfMagic/Vertex/actions/workflows/ci.yml/badge.svg" height="25" alt="ci" /></a>
</div>

### 📖 Описание
___

Настольное приложение для случайного обновления отображаемого числа от 0 до 100. Можно обновлять число по таймеру с 
интервалом: 1 секунда или 1,5 секунды.

### ❗ Требования
___

* **JDK**: 18 или выше;
* **Сконфигурированная переменная окружения**: JAVA_HOME.

### 📋 Инструкция по запуску
___

*Все команды выполняются в консоли.*
1. Создать папку: `mkdir GitProjects`;
2. Перейти в нее: `cd GitProjects`;
3. Клонировать код репозитория: `git clone https://github.com/HogwartsSchoolOfMagic/Vertex.git`;
4. Перейти в созданную папку: `cd Vertex`;
5. Собрать проект: `mvn clean install`;
6. После выполнения 5 пункта — будет создана папка с именем **“target”**. Переходим в нее: `go target`;
7. Внутри будет находиться файл **“vertex-1.0.0.jar”**.
Запускаем его командой: `java -jar vertex-1.0.0.jar`;
8. Запустится GUI приложение **(см. "Интерфейс приложения")**.

**Бонус**: вместо 7 пункта можно действовать иначе.
В папке — **target**, также есть файл: **vertex.exe**, который можно просто запустить.
Если возникнут проблемы — пиши мне.

```java
public class VertexApplication {

  public static void main(String[] args) { // Используется для запуска приложения.
    Runnable runnable = VertexUtil::started;
    invokeLater(runnable);
  }
}
```

### 💻 Интерфейс приложения
___
<div align="center">
   <img style="border: solid #465241;" src="https://raw.githubusercontent.com/HogwartsSchoolOfMagic/Vertex/master/assets/vertex-form.gif" alt="gui-interface" />
</div>

<div align="center">
   <img style="border: solid #465241;" src="https://raw.githubusercontent.com/HogwartsSchoolOfMagic/Vertex/master/assets/vertex-form-popup-menu.png" alt="gui-interface" />
</div>

### 🎫 Лицензия
___

**[Apache License Version 2.0](https://github.com/HogwartsSchoolOfMagic/Vertex/blob/master/LICENSE)**

_Copyright ©2022, Vladislav [[SmithyVL]](https://github.com/SmithyVL) Kuznetsov_