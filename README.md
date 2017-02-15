[![Build Status](https://travis-ci.org/rselvanathan/mailsender-scala.svg?branch=master)](https://travis-ci.org/rselvanathan/mailsender-scala)

##Automated Mail Sender (Scala Version)

A simple mailing application that will use AWS SQS to process messages and send e-mails to the appropriate destinations.
Each type of Application will have it's own template defined, which will then be used to send a specific message to a user.

This is a Scala rewrite of the original application written in java at :
https://github.com/rselvanathan/mailsender

This version is the current active version being used in my Instances.

The AWS SQS is polled at a given interval. The application itself is currently synchronous, but may be extended to be 
asynchronous in the future (The Java version is Asynchronous).

Tech Used : AWS SQS, Scala

###Docker Usage

The application is currently being deployed as a docker image. To run the image enter the following command : 

```bash
docker run -d --name mailsender-scala \
-e AWS_ACCESS_KEY_ID=\ 
-e AWS_SECRET_ACCESS_KEY=\
-e MAIL_HOST=smtp-\
-e MAIL_PORT=\
-e MAIL_USERNAME=\
-e MAIL_PASSWORD=\
-e AWS_SQS_QUEUE_URL=\
-e MESSAGE_RETRIEVE_DELAY=\
-it rselvanathan/mailsender-scala:latest
```

###### Author

Romesh Selvanathan
