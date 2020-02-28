Feature: Dashboard Page

  @dashboard
  Scenario: Dashboard Settings Menu
    Given the user login the page
    When The user navigates to Settings Menu
    And Clicks to settings button
    Then the user should see following input options
      | Profile picture | Details | Full name | Email | Phone number | Address | Website | Twitter | Language | Locale |
