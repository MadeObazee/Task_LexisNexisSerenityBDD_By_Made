Serenity BDD with JAVA. Framework Design: Created a Maven project with all required dependencies copied over from the Serenity cucumber starter project. Please ensure all dependencies are loaded before running the test. All dependencies are available in pom.xml file .  Open and load the project from a zip file and then build the project Entry point for this project is the feature file where the test scenario has been documented for better understanding of the user journey. You can run the test directly from the feature file by clicking the run or green button to the left of the scenario title or run './mvnw clean verify' from the command line The framework include: 

1. Feature > VerifyFinancialMenu.feature 
2. PageObjects >  HomePage 
3. StepDefinitions > VerifyFinancialMenuStepsDef 


File contains the test scenario as this allows for gherkin syntax in writing the scenario steps to be automated. HomePage contains locators and methods which drives the test VerifyFinancialMenuStepsDef contains binding step definition which directly links the both the feature file and the page objects for better co-ordination and to maintain an organised architechtural design for the project.

Note: I created just one page and step definition which is Homepage and VerifyFinancialMenuStepsDef  for simple use. There is Financial Service page which I should I have created but I just stick to one page and step definition for this task due to time.
