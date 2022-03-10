Feature: Login
  As user, I want to be able to login into Borrower Portal Application.

  @login @borrowerportal
    Scenario: Log in with valid credentials
      Given user is registered borrower
      When he login to his Borrower Portal account
      Then he verifies logged in successfully