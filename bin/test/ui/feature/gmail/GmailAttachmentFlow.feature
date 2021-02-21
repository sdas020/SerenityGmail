@gmailAttachments @gmail
Feature: Gmail mail attachment flow

  @gmailAttachmentDoc
  Scenario Outline: User logged in using credential and attached document.
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>
    Then User validate the gmail page
    And user upload attachment in compose with <recipientMailId> , <mailSubject> , <mailBody>

    Examples: 
      | TestCase | Email         | password         | recipientMailId        | mailSubject | mailBody                     |
      | TC_4     | Provide Email | Provide password | Provide recipient mail | Test Mail   | Hello, this is the test mail |
