# livy_programmaticAPI
java implementation of livy programmatic API

#project does not work at the moment

## Usage:
- install Apache Maven
- clone this repository
- follow the next instructions

### instructions:
to build the jar for the upload change into the jarJob project directory
```sh
$ cd livy_programmaticAPI
$ cd jarJob
```
build the jar(for the upload) with maven:
in the jarJob directory type
```sh
$ mvn clean install
```
this creates the jarJob-1.jar jar-File into the livy_programmaticAPI/jar-Job/target folder

now use the *cd* command and switch into the mainModule folder and type
```sh
$ mvn compile
$ mvn exec:java -Dexec.mainClass="groupIDmainModule.App"
```
this still provokes an error.
