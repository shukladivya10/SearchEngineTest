# Search Engine Testing Project

This project is a simple Selenium-based test suite for testing various search engines (Google, Bing, Yahoo). It uses TestNG for test organization and Maven as the build tool.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Local Setup](#local-setup)
- [Running Locally](#running-locally)
- [Jenkins Integration](#jenkins-integration)

## Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Chrome Browser](https://www.google.com/chrome/)

## Project Structure

The project is structured as follows:
- src
  - test
    - java
      - com
        - test
          - selenium
            - SearchTestBase.java
            - SearchEngineTest.java
    - resources
      - config.properties
      - regression-suite-dev.xml
      - regression-suite-prod.xml

- `SearchTestBase.java`: Base class containing common setup and teardown logic for Selenium tests.
- `SearchEngineTest.java`: Test class containing actual Selenium tests for search engines.
- `regression-suite-dev.xml`: TestNG XML file specifying the test suite and parameters for dev environment (Representing smaller set of regression suite).
- `regression-suite-prod.xml`: TestNG XML file specifying the test suite and parameters for prod environment (Representing larger set of regression suite).

## Local Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/shukladivya10/SearchEngineTest.git
   cd search-engine-testing

2. Install the required dependencies:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Chrome Browser](https://www.google.com/chrome/)

3. Set up environment variables:

- Ensure that the Java and Maven executable paths are added to your system's `PATH`.
- Optionally, set environment variables for `JAVA_HOME` and `M2_HOME` to point to your JDK and Maven installations.

# Running Locally

## Build and Run Tests

To build and run the tests locally, use the provided shell script:

```bash
chmod +x build_locally.sh
./build_locally.sh

This script sets the environment variable, determines the TestNG XML file based on the environment, and then checks if the file exists before running the Maven build and test command.

## Viewing Test Results

After the tests complete, you can view the test results in the target/surefire-reports directory. Open the generated HTML reports in your browser.

# Jenkins Integration

## Jenkinsfile
The Jenkinsfile defines the pipeline for building and testing the project in Jenkins. Ensure that you have Jenkins set up with the necessary plugins and configurations.

1. Create a new Pipeline project in Jenkins.
2. Set the pipeline script source to "Pipeline script from SCM."
3. Specify the repository URL (e.g., https://github.com/shukladivya10/SearchEngineTest.git).
4. Add the Jenkinsfile to the root of your project repository.

## Triggering Builds
You can manually trigger builds in Jenkins or set up periodic builds using the Jenkins scheduling feature.
