Feature: Submit Order

    Feature To validate Submit Order


    Background: Launch the application
    Given the ecommerce application is Launch

    @tag1123
    Scenario Outline: Test Submit Order Functionality
    Given the user logged in with <username> and <password>
    And the user add the <product> into cart
    And the user checkout <product> and submit Order
    Then the user validates "THANKYOU FOR THE ORDER." message is displayed

    Examples:
        | username | password | product |
        | smasherrock33@gmail.com  | Smasher@123  | ADIDAS ORIGINAL |

