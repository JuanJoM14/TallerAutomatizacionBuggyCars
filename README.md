Para correr todos los escenarios y la e2e de corrido, ademas generar el reporte: .\gradlew.bat serenityReport

Para correr solo la e2e: .\gradlew.bat clean serenityReport "-Dcucumber.filter.tags=@e2e"

Para correr solo el register: .\gradlew.bat clean serenityReport "-Dcucumber.filter.tags=@registro"

Para correr solo el login: .\gradlew.bat clean serenityReport "-Dcucumber.filter.tags=@login"

Para correr solo el comment: .\gradlew.bat clean serenityReport "-Dcucumber.filter.tags=@comentario"
