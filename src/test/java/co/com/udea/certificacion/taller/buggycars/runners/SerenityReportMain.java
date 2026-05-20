package co.com.udea.certificacion.taller.buggycars.runners;

import java.io.File;
import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;

public class SerenityReportMain {

    public static void main(String[] args) throws Exception {
        File sourceDir = new File("target/site/serenity");

        if (!sourceDir.exists()) {
            throw new IllegalStateException("Serenity source directory not found: " + sourceDir.getAbsolutePath());
        }

        HtmlAggregateStoryReporter reporter = new HtmlAggregateStoryReporter("TallerAutomatizacionBuggyCars");
        reporter.setSourceDirectory(sourceDir);
        reporter.setOutputDirectory(sourceDir);
        reporter.setProjectDirectory(new File(".").getAbsolutePath());
        reporter.generateReportsForTestResultsFrom(sourceDir);
    }
}
