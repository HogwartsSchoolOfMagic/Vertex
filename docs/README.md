<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <h1>
        <a href="https://funprojectsforsoul.github.io/Vertex/">Vertex</a>
    </h1>
</div>

<div align="center">
    <a href="https://github.com/FunProjectsForSoul/Vertex/blob/master/docs/translations/README_RU.md">
        <img alt="russian-version" src="https://raw.githubusercontent.com/FunProjectsForSoul/Vertex/master/assets/languages/russian.png"/>
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

### 📖 Description
___

Desktop application for random updating of the displayed number from 0 to 100. It is possible to start updating the 
number by timer at intervals: 1 second or 1.5 seconds.

### ❗ Requirements
___

* **JDK**: 8 and higher;
* **Configured environment variable**: JAVA_HOME.

### 📋 Instructions for starting the project
___

*All commands are executed in the console.*
1. Create a folder: `mkdir GitProjects`;
2. Go to the folder: `cd GitProjects`;
3. Cloning a repository: `git clone https://github.com/FunProjectsForSoul/Vertex.git`;
4. Go to the folder: `cd Vertex`;
5. Build project: `mvn clean install`;
6. After completing 5 points — a folder with the name **“Target”** will be created. We go into it: `go target`;
7. Inside there will be a JAR file named **“vertex-0.2.2.jar”**.
   We execute the command: `java -jar vertex-0.2.2.jar`;
8. The GUI application will start **(see: Application interface)**.

**Bonus**: instead of point 7, you can act differently.
In the folder — **target**, there will also be a file: **vertex.exe**, which you can simply run.
If you have any problems — write to me.

```java
public class VertexApplication {

  public static void main(String[] args) { // Used to launch the application.
    Runnable runnable = VertexUtil::started;
    invokeLater(runnable);
  }
}
```

### 💻 Application interface
___
<div align="center">
   <img src="https://raw.githubusercontent.com/FunProjectsForSoul/Vertex/master/assets/vertex-form.gif" alt="gui-interface" />
</div>

<div align="center">
   <img src="https://raw.githubusercontent.com/FunProjectsForSoul/Vertex/master/assets/vertex-form-popup-menu.png" alt="gui-interface" />
</div>

### 🎫 License
___

**[Creative Commons Legal Code](https://github.com/Bangerok/Vertex/blob/master/LICENSE)**

_Copyright ©2021, Vladislav [[Bangerok]](https://github.com/Bangerok) Kuznetsov_