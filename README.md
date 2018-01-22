About: learning to create Android app automation tests

IMPORTANT INFO: Please use maven 3.2 for test execution. Versions of other tools used for autotests creation are described in pom.xml file.

1. To run test by flag:
mvn clean test -Dcucumber.options="--tags @tutorial" -Djava.net.preferIPv4Stack=true -Dlog4j.configuration=log4j.properties

2. To run test by name:
mvn clean test -Dcucumber.options="--name 'Register new beneficiary' " -Djava.net.preferIPv4Stack=true -Dlog4j.configuration=log4j.properties

3. To run all scenarios:
mvn clean test


//TODO: Create different avd files with different configuration and startup them by AVD Manager programmatically using command line
//TODO: Add logging to all steps for clear picture of execution

