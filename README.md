##Automated Mail Sender (Scala Version)

A simple mailing application that will use AWS SQS to process messages and send e-mails to the appropriate destinations.
Each type of Application will have it's own template defined, which will then be used to send a specific message to a user.

This is a Scala rewrite of the original application written in java at :
https://github.com/rselvanathan/mailsender

The AWS SQS is polled at a given interval. The application itself is currently synchronous, but may be extended to be 
asynchronous in the future (The Java version is Asynchronous).

Tech Used : AWS SQS, Scala

###### Author

Romesh Selvanathan
