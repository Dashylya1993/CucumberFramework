$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/nameValidationinDB.feature");
formatter.feature({
  "name": "Anme validation against DB",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "First name validation against DB - serching by Employee ID",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@dbValiation"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the dashboard logo is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.verify_the_dashboard_logo_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to employee list",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinition.navigate_to_employee_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "search for an employee with valid Employee id \"0056266\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinition.click_on_search_Button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify the table is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinition.verify_the_table_is_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "get first name from the table",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinition.get_first_name_from_the_table()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "get first name from the db",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.DBStepDefinitions.get_first_name_from_the_db()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "validate first name from ui against db",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinition.validate_first_name_from_ui_against_db()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", "First name validation against DB - serching by Employee ID");
formatter.after({
  "status": "passed"
});
});