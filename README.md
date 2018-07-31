# employee-tree

## Downstream Dependencies
[mentor-tree](https://github.com/nppatel4/mentor-tree) depends on this project to display employee information.

## Build
```bash
./gradlew clean assemble
```

## Run Locally
The `local` spring profile should be used when running locally. The gradle `bootRun` task has been configured to use the local profile by default.
```bash
./gradlew bootRun
```

### IntelliJ
Include `local` in the *Active profiles* field in the *Run Configuration* for the Spring Boot application.

## Swagger UI (API Docs)
[swagger on localhost](http://localhost:8081/swagger-ui.html)

## Deploy to PCF
Store your CF username and password in environment variables:
```bash
export CF_CCUSER="<pcf-username>"
export CF_CCPASSWORD="<pcf-password>"
```
Use the CF gradle plugin to push:
```bash
./gradlew cf-push -Pcf.space=<your-space-name-here>
```
