package co.com.udea.certificacion.taller.buggycars.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/buggycars.feature",
        glue = "co.com.udea.certificacion.taller.buggycars.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class BuggyCarsRunner {}
