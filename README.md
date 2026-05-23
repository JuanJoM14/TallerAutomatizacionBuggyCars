Para correr todos los escenarios y la e2e de corrido, ademas generar el reporte: .\gradlew.bat serenityReport

Para correr solo la e2e: .\gradlew.bat clean serenityReport "-Dcucumber.filter.tags=@e2e"
