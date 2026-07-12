@register
Feature: Register User

Background:
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify New User SignUp is visible


@positive
Scenario Outline: Register New User Successfully

When User enters signup details

| name | gender | password | day | month | year | fname | lname | address | country | state | city | zipcode | mobile |
| <name> | <gender> | <password> | <day> | <month> | <year> | <fname> | <lname> | <address> | <country> | <state> | <city> | <zipcode> | <mobile> |

Then Verify account created

Examples:

| name | gender | password | day | month | year | fname | lname | address | country | state | city | zipcode | mobile |
| Kousalya | Female | Test@123 | 1 | January | 2000 | Kousalya | A | Hyderabad | India | Telangana | Hyderabad | 500001 | 9876543210 |
| Priya | Female | Test@123 | 2 | February | 1999 | Priya | B | Bangalore | India | Karnataka | Bangalore | 560001 | 9876543211 |


@negative
Scenario: Register With Existing Email

When User enters existing user details
Then Verify email already exists error


@negative
Scenario: Register With Invalid Email

When User enters invalid email
Then Verify invalid email validation


@negative
Scenario: Register Without Name

When User enters empty name
Then Verify required validation


@negative
Scenario: Register Without Email

When User enters empty email
Then Verify required validation


@negative
Scenario: Register Without Name And Email

When User enters empty name and email
Then Verify required validation


@positive
Scenario: Register With Special Characters In Name

When User enters special character name
Then Verify signup page opened


@positive
Scenario: Register With Long Name

When User enters long name
Then Verify signup page opened


@positive
Scenario: Register With Spaces In Name

When User enters name with spaces
Then Verify signup page opened


@positive1
Scenario: Register And Logout

When User enters signup details

| name | gender | password | day | month | year | fname | lname | address | country | state | city | zipcode | mobile |
| TestUser | Male | Test@123 | 10 | May | 1998 | Test | User | Hyderabad | India | Telangana | Hyderabad | 500001 | 9876543212 |

Then Verify account created
When User clicks Logout button
Then Verify Login page displayed