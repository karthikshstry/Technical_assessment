Feature: Assessment

  Scenario: Verify sort movies by Title and assert the last movie in the list is The Phantom Menace
    Given I navigate to Star wars Home page
    When I click on Title column
    Then I should see the last movie in the list is The Phantom Menace

  Scenario:  View the movie The Empire Strikes Back and check if the Species list has Wookie
    Given I navigate to Star wars Home page
    When I select the movie The Empire Strikes Back
    Then I should see the Species list has Wookie

  Scenario:  Assert that Planets Camino is not part of the movie The Phantom Menace
    Given I navigate to Star wars Home page
    When I select the movie The Phantom Menace
    Then I should not see the Planets Camino in the list for movie The Phantom Menace


  Scenario: Get the list of movies and check if the movies count is 6
    Given Send the request and verify the response


  Scenario:  Get the 3rd movie and check if the director of the movie is Richard Marquand
    Given Send the request and verify the response to verify director of the movie

  Scenario:   Get the 5th movie and assert that Producers are not Gary Kurtz George Lucas
    Given Send the request and verify the response to verify producers of the movie









