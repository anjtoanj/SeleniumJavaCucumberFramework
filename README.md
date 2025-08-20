 website : https://parabank.parasoft.com/parabank/index.htm
 
 #FOLDER STRUCTURE

/Parabank
├── src
│   ├── main
│   │   └── java
│   │       ├── pages
│   │       │   └── HomePagev1
│   │       └── utility
│   │           └── DriverManager
│   └── test
│       ├── java
│       │   ├── features
│       │   │   └── HomePage.feature
│       │   ├── runner
│       │   │   └── TestRunner
│       │   ├── stepDefinitions
│       │   │   └── HomePage
│       │   ├── testcases
│       │   │   └── TC01HomePage
│       │   └── hooks
│       │       └── Hooks
│       └── resources
│           └── config
│               └── config.properties
│               └── cucumber.properties
├── pom.xml
├── .github
│   └── workflows
│       └── SeleniumJavaBDD.yml
├── .gitignore
└── testng.xml

#DONE
-Parallel runs on different browsers faciliated through tags on Scenario in feature file


#For parallel execution :
Can keep a default browser, but will override it in TestNG XML for parallel execution.


#SETUP SELENIUM GRID
Download Selenium Server: https://www.selenium.dev/downloads/
Start Hub:
java -jar selenium-server-<version>.jar hub
Default URL: http://localhost:4444
Start Node(s) (can be local or remote):
java -jar selenium-server-<version>.jar node --detect-drivers
LOCAL HOST :   http://192.168.7.213:4444


#ISSUES
