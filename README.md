To run the test suite, follow these quick steps:

Configure Test Suite: Open your pom.xml file, locate the <properties><suitePath></suitePath></properties> block, specify the path to the test suite XML file you want to execute, and comment out the rest.

Execute Tests: Run the following command in your terminal:
Bash
mvn clean test

View Test Reports: Generate and view the interactive Allure test report by running:
Bash
allure serve target/allure-results
