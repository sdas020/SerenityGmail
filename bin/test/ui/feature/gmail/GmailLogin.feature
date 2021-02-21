@gmailLogin @gmail
Feature: Gmail mail login flow

  @gmailSignInFlow
  Scenario Outline: User logged in using correct credential
    Given User navigating to gmail signIn page
    When User login with <Email> and <password>

    Examples: 
      | TestCase | Email         | password         |
      | TC_1     | Provide Email | Provide password |

  @gmailSignInWrongMail
  Scenario Outline: User logged in using credential with invalid email.
    Given User navigating to gmail signIn page
    When User signIn with invalid <Email>
    Then User validates <ErrorMessage>

    Examples: 
      | TestCase | Email               | ErrorMessage                      |
      | TC_2     | Provide wrong email | Couldn't find your Google Account |

  @gmailSignInWrongPassword
  Scenario Outline: User logged in using credential with invalid password.
    Given User navigating to gmail signIn page
    When User signIn with <Email> and invalid <password>
    Then User validates <ErrorMessage>

    Examples: 
      | TestCase | Email         | password               | ErrorMessage                                                      |
      | TC_3     | Provide Email | Provide wrong password | Wrong password. Try again or click ‘Forgot password’ to reset it. |
