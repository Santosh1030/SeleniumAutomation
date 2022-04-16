Feature: Login
  As a user
  I should login and use the application

  Background:
    Given Im on home page "https://www.amazon.co.uk" with title as "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"

  Scenario: Verify login with valid username and password

    When I click on signIn page link
    When I enter username "santosh.pujari1030@gmail.com"
    And I click continue
    And I enter password "89850A97c0"
    And I click signIn button
    Then I should be landed on product page with heading text as ".co.uk"

  Scenario:Verify login with valid username and invalid password


    When I click on signIn page link
    When I enter username "santosh.pujari1030@gmail.com"
    And I click continue
    And I enter password "dfgyyaebj"
    And I click signIn button
    Then I should see a text in the same page with heading as  "there was a problem" and text as "your password is incorrect"

  Scenario:Verify login with invalid username


    When I click on signIn page link
    When I enter username "gdatyat@gmail.com"
    And I click continue
    Then I should see a text in the same page as "there was a problem we cannot find an account with that email address"

  Scenario:Verify login with No username


    When I click on signIn page link
    When I enter username ""
    And I click continue
    Then I should see a text in the same page as "Enter your e-mail address or mobile phone number"