package edu.pe.cibertec.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "edu.pe.cibertec.stepdefinitions"
)
@ConfigurationParameter(
        key = "cucumber.plugin",
        value = "io.cucumber.core.plugin.SerenityReporterParallel"
)
public class NavigationRunner {
}
