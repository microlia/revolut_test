IMPORTANT INFO: Please use maven 3.2 for test execution. Versions of other tools used for autotests creation are described in pom.xml file.

1. To run test by flag:
mvn clean test -Dcucumber.options="--tags @tutorial" -Djava.net.preferIPv4Stack=true -Dlog4j.configuration=log4j.properties

2. To run test by name:
mvn clean test -Dcucumber.options="--name 'Register new beneficiary' " -Djava.net.preferIPv4Stack=true -Dlog4j.configuration=log4j.properties

3. To run all scenarios:
mvn clean test


//TODO: Create different avd files with different configuration and startup them by AVD Manager programmatically using command line

BUGS:
1. Critical: Adding new account. Application crashes when user uploads photo made via android camera to app as confirmation documents for account.
Restart of application doesn't help. Reinstallation of app was needed to fix the issue. Note: documents are mentioned by app as sent for the user
as the app doesn't ask user to upload docs once more after reinstallation. Environment: Nexus 6, Android 7.0 on emulator

2. Minor: Sign up form. When user enters his phone number and click Next system should ask for pin code. On physical device user has to click Next button twice
for pin code input form. Environment: LG K200, Android 7.0 on physical device. Severity is minor because this issue can be treated by user as network issue.

3. Trivial: Sign up tutorial ("Spend without fees" page):
Expected: When using RevolutCard, you will get the real exchange rate and always free spending
Actual: When using RevolutCard, you will get the real exchange rate and spending is always free

4. Trivial: Sign up tutorial ("Control your card security"):
Expected:  you can disable ATM transactions, contactless payments and so much more!
Actual: you can disabled ATM transactions, contactless payments and so much more!
