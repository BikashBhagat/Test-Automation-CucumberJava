#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Log in Scenario to the appliaction
  I want to use this template for my feature file

  @tag1
  Scenario: Log in
    Given url launch in new window
    And user maximize the window
    When use enter user name in username textbox
    And use enter password in password textbox
    Then user validated in user log in successfull



  @tag3
  Scenario: Log in
    Given url launch in new window
    And user maximize the window
    When use enter user name in username textbox
    And use enter password in password textbox
    Then user validated in user log in successfull
  #@tag2
  #Scenario Outline: Log in
    #Given url launch in new window
    #And user maximize the window
    #When use enter user name in <username> textbox
    #And use enter password in <password> textbox
    #Then user validated in user log in successfull
#
#
    #Examples: 
      #| username  | password |
      #| name1 |Test1 |
      #| name2 |Test2 |
