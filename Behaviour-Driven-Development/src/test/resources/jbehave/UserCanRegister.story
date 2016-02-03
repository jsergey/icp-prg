# UserCanRegister.story
Scenario: User Can Register

Given non authenticated user
When Sergey creates account using name@mail.com and secret
Then account is created
Then Sergey can tweet