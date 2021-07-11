<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <h1>
        <a href="https://funprojectsforsoul.github.io/Vertex/">Vertex</a>
    </h1>
</div>

<div align="center">
    <a href="https://github.com/HogwartsSchoolOfMagic/Vertex/blob/master/docs/translations/README_RU.md">
        <img alt="russian-version" src="https://raw.githubusercontent.com/HogwartsSchoolOfMagic/Vertex/master/assets/languages/russian.png"/>
    </a>
</div>

<div align="center">
    <img src="https://img.shields.io/github/last-commit/HogwartsSchoolOfMagic/Vertex" height="25" alt="last-commit" />
    <a href="https://wakatime.com/@SmithyVL"><img src="https://wakatime.com/badge/github/HogwartsSchoolOfMagic/Vertex.svg" height="25" alt="time-with-code" /></a>
    <a href="https://sonarcloud.io/code?id=HogwartsSchoolOfMagic_Vertex"><img src="https://sonarcloud.io/api/project_badges/measure?project=HogwartsSchoolOfMagic_Vertex&metric=ncloc" height="25" alt="sonar-code-lines" /></a>
    <a href="https://sonarcloud.io/summary/new_code?id=HogwartsSchoolOfMagic_Vertex"><img src="https://sonarcloud.io/api/project_badges/measure?project=HogwartsSchoolOfMagic_Vertex&metric=alert_status" height="25" alt="sonar-quality-gate-status" /></a>
    <a href="https://github.com/HogwartsSchoolOfMagic/Vertex/actions/workflows/ci.yml"><img src="https://github.com/HogwartsSchoolOfMagic/Vertex/actions/workflows/ci.yml/badge.svg" height="25" alt="ci" /></a>
</div>

### 📖 Description
___

Desktop application for random updating of the displayed number from 0 to 100. It is possible to start updating the 
number by timer at intervals: 1 second or 1.5 seconds.

### ❗ Requirements
___

* **JDK**: 18 and higher;
* **Configured environment variable**: JAVA_HOME.

### 📋 Instructions for starting
___

*All commands are executed in the console.*
1. Create a folder: `mkdir GitProjects`;
2. Go to the folder: `cd GitProjects`;
3. Cloning a repository: `git clone https://github.com/HogwartsSchoolOfMagic/Vertex.git`;
4. Go to the folder: `cd Vertex`;
5. Build project: `mvn clean install`;
6. After completing 5 points — a folder with the name **“Target”** will be created. We go into it: `go target`;
7. Inside there will be a JAR file named **“vertex-1.0.0.jar”**.
   We execute the command: `java -jar vertex-1.0.0.jar`;
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
   <img style="border: solid #465241;" src="https://raw.githubusercontent.com/HogwartsSchoolOfMagic/Vertex/master/assets/vertex-form.gif" alt="gui-interface" />
</div>

<div align="center">
   <img style="border: solid #465241;" src="https://raw.githubusercontent.com/HogwartsSchoolOfMagic/Vertex/master/assets/vertex-form-popup-menu.png" alt="gui-interface" />
</div>

### 🎫 License
___

**[Apache License Version 2.0](https://github.com/HogwartsSchoolOfMagic/Vertex/blob/master/LICENSE)**

_Copyright ©2022, Vladislav [[SmithyVL]](https://github.com/SmithyVL) Kuznetsov_