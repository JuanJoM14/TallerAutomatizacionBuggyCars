package co.com.udea.certificacion.taller.buggycars.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "co.com.udea.certificacion.taller.buggycars.stepdefinitions",
        plugin = {
                //reporte con cucumber (sin embargo, el reporte de serenity es más completo)
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class BuggyCarsRunner {}
