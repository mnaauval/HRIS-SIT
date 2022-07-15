#Author: mnaauval@gmail.com
Feature: Login

  Scenario: Login valid
    Given User at Login Page
    When Input valid uname "EXD8120011" and valid passwd "admin12345"
    Then User click login
    And User logged in
