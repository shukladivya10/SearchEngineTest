#!/bin/bash

# Set the environment variable for the desired environment (dev or prod)
export ENVIRONMENT=dev

# Set the path to the TestNG XML file based on the environment
DEV_SUITE_XML="./src/test/resources/testng.xml"
PROD_SUITE_XML="./src/test/resources/regression-suite-prod.xml"

# Check if the environment variable is set and use the appropriate testng.xml file
if [ "$ENVIRONMENT" == "dev" ]; then
    SUITE_XML_FILE=$DEV_SUITE_XML
elif [ "$ENVIRONMENT" == "prod" ]; then
    SUITE_XML_FILE=$PROD_SUITE_XML
else
    echo "Invalid environment specified"
    exit 1
fi

# Check if the testng.xml file exists
if [ -f "$SUITE_XML_FILE" ]; then
    echo "Building and running the project..."
    mvn clean test -DsuiteXmlFile="$SUITE_XML_FILE"
else
    echo "TestNG XML file does not exist: $SUITE_XML_FILE"
    exit 1
fi