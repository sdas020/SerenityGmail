$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/ui/feature/gmail/GmailSendEmailFlow.feature");
formatter.feature({
  "name": "Gmail send email flow",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@gmailSendEmail"
    },
    {
      "name": "@gmail"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User send email with invalid receipent mail.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gmailSendEmailWithInvalidReceipentEmailAddress"
    }
  ]
});
formatter.step({
  "name": "User navigating to gmail signIn page",
  "keyword": "Given "
});
formatter.step({
  "name": "User login with \u003cEmail\u003e and \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "User validate the gmail page",
  "keyword": "Then "
});
formatter.step({
  "name": "user upload attachment in compose with \u003creceipentMailId\u003e , \u003cmailSubject\u003e , \u003cmailBody\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "User send the mail to receipent",
  "keyword": "Then "
});
formatter.step({
  "name": "User is validating the inbox for invalid email address as receipent",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "TestCase",
        "Email",
        "password",
        "receipentMailId",
        "mailSubject",
        "mailBody"
      ]
    },
    {
      "cells": [
        "TC_10",
        "test100timesalltime@gmail.com",
        "test@1234",
        "junkvfhfvhfdag23456@gmail.com",
        "Test Mail",
        "Hello, this is the test mail"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User send email with invalid receipent mail.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gmailSendEmail"
    },
    {
      "name": "@gmail"
    },
    {
      "name": "@gmailSendEmailWithInvalidReceipentEmailAddress"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigating to gmail signIn page",
  "keyword": "Given "
});
formatter.match({
  "location": "GmailAttachmentFlowSteps.user_navigating_to_gmail_sign_in_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login with test100timesalltime@gmail.com and test@1234",
  "keyword": "When "
});
formatter.match({
  "location": "GmailAttachmentFlowSteps.user_login(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validate the gmail page",
  "keyword": "Then "
});
formatter.match({
  "location": "GmailAttachmentFlowSteps.user_validate_the_gmail_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user upload attachment in compose with junkvfhfvhfdag23456@gmail.com , Test Mail , Hello, this is the test mail",
  "keyword": "And "
});
formatter.match({
  "location": "GmailAttachmentFlowSteps.user_upload(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User send the mail to receipent",
  "keyword": "Then "
});
formatter.match({
  "location": "GmailAttachmentFlowSteps.user_SendMail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is validating the inbox for invalid email address as receipent",
  "keyword": "Then "
});
formatter.match({
  "location": "GmailAttachmentFlowSteps.user_validate_inbox_emailAddress()"
});
formatter.result({
  "status": "passed"
});
});