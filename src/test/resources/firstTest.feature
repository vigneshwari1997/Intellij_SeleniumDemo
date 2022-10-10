Feature: Messaging between Provider and Patient

  Background: Open Altais Website
    @messaging
    Scenario Outline: The user should be able to create conversation

      Given the provider logged in successfully
      When navigates to messaging screen
      And Creates conversation with patient "<to>" "<subject>" "<message>"
      Then the created conversation should be displayed

      Examples:
      | to    | subject | message |
      | Kelvin|  Test   | Hello   |
#      |Mia    | Test1   | Hi      |