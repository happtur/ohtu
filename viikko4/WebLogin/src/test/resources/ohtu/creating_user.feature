Feature: A new user account can be created if a proper unused username and a proper password are given

    Scenario: creation succesful with correct username and password
        Given new user is selected
        When  available and valid username "malla" and valid password "password123" and password confirmation "password123" are given
        Then  user is created

    Scenario: creation fails with too short username and valid passord
        Given new user is selected
        When  too short username "ab" and valid password "12345abc" and password confirmation "12345abc" are given
        Then user is not created and error "username should have at least 3 characters" is reported 

    Scenario: creation fails with correct username and too short password
        Given new user is selected
        When  available and valid username "sisilisko" and too short password "short1" and password confirmation "short1" are given
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails with correct username and password consisting of letters
        Given new user is selected
        When  available and valid username "wigwam" and letter password "letterss" and password confirmation "letterss" are given
        Then user is not created and error "password can not contain only letters" is reported 

    Scenario: creation fails with already taken username and valid pasword
        Given new user is selected
        When  unavailable username "jukka" and valid password "salasana123" and password confirmation "salasana123" are given
        Then user is not created and error "username is already taken" is reported 

    Scenario: creation fails when password and password confirmation do not match
        Given new user is selected
        When  available and valid username "wigwam" and valid password "password1" and incorrect password confirmation "notpassword" are given
        Then user is not created and error "password and password confirmation do not match" is reported  