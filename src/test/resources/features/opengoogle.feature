Feature: Docker google UI automation

@runMe
Scenario: Open google and search for keyword Selenium
Given I have the url for google search
When I navigate to google dot com
Then I see a text box and enter a search keyword