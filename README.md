# micronaut-testcase

./gradlew build 

Results in injection failure, due to test class names being similar and using MockBean.
If you rename one of the test classes, then both will pass.