Feature: Create file funcitions.

  @todo
  Scenario Outline: user should be able to create file or folder or to upload file
    Given the user login the page
    When click create button
    And create "<type>" "<file name>"
    Then verify "<type>" "<file name>" uploaded succesfully
    Examples:
      | type          | file name       |
      | New text file | Bit_Biterss     |
      | Upload file   | Bit_Biters.jpeg |
      | New folder    | Bit_Bitersss    |
      | New text file | Bit_Biterss     |
      | Upload file   | Bit_Biters.jpeg |
      | New folder    | Bit_Bitersss    |

  @todo
  Scenario: user should be able to delete files or folders
    Given the user login the page
    When click search button
    Then delete listed items "Bit_Biters"




