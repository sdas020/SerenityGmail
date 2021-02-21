@gmailSendEmail @gmail
Feature: Gmail send email flow

  @gmailSendEmailWithDoc
  Scenario Outline: User send email with document.
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>
    Then User validate the gmail page
    And user upload attachment in compose with <recipientMailId> , <mailSubject> , <mailBody>
    Then User send the mail to recipient

    Examples: 
      | TestCase | Email         | password         | recipientMailId        | mailSubject | mailBody                     |
      | TC_5     | Provide Email | Provide password | Provide recipient mail | Test Mail   | Hello, this is the test mail |

  @gmailSendEmailWithoutDoc
  Scenario Outline: User send email without document.
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>
    Then User validate the gmail page
    And user compose mail without document <recipientMailId> , <mailSubject> , <mailBody>
    Then User send the mail to recipient

    Examples: 
      | TestCase | Email         | password         | recipientMailId        | mailSubject | mailBody                     |
      | TC_6     | Provide Email | Provide password | Provide recipient mail | Test Mail   | Hello, this is the test mail |

  @gmailSendEmailWithoutRecipientmail
  Scenario Outline: User send email without recipient mail.
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>
    Then User validate the gmail page
    And user upload attachment in compose with <recipientMailId> , <mailSubject> , <mailBody>
    Then User send the mail to recipient
    Then User is validating the alert error message <ErrorMessage>

    Examples: 
      | TestCase | Email         | password         | recipientMailId | mailSubject | mailBody                     | ErrorMessage                           |
      | TC_7     | Provide Email | Provide password |                 | Test Mail   | Hello, this is the test mail | Please specify at least one recipient. |

  @gmailSendEmailWithoutMailSubject
  Scenario Outline: User send email without mail subject.
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>
    Then User validate the gmail page
    And user upload attachment in compose with <recipientMailId> , <mailSubject> , <mailBody>
    Then User send the mail to recipient

    Examples: 
      | TestCase | Email         | password         | recipientMailId        | mailSubject | mailBody                     |
      | TC_8     | Provide Email | Provide password | Provide recipient mail |             | Hello, this is the test mail |

  @gmailSendEmailWithoutMailBody
  Scenario Outline: User send email without mail body.
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>
    Then User validate the gmail page
    And user upload attachment in compose with <recipientMailId> , <mailSubject> , <mailBody>
    Then User send the mail to recipient

    Examples: 
      | TestCase | Email         | password         | recipientMailId        | mailSubject | mailBody |
      | TC_9     | Provide Email | Provide password | Provide recipient mail | Test Mail   |          |

  @gmailSendEmailWithInvalidRecipientEmailAddress
  Scenario Outline: User send email with invalid recipient mail.
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>
    Then User validate the gmail page
    And user upload attachment in compose with <recipientMailId> , <mailSubject> , <mailBody>
    Then User send the mail to recipient
    Then User is validating the inbox for invalid email address as recipient

    Examples: 
      | TestCase | Email         | password         | recipientMailId                   | mailSubject | mailBody                     |
      | TC_10    | Provide Email | Provide password | Provide invalid recipient mail ID | Test Mail   | Hello, this is the test mail |
