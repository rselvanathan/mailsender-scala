docker pull rselvanathan/mailsender-scala:latest
isImageRunning=$(docker inspect -f {{.State.Running}} mailsender-scala 2> /dev/null)
if [ "$isImageRunning" = "true" ]; then
	echo "Removing mailsender-scala container"
	docker stop mailsender-scala
	docker rm mailsender-scala
fi
value=$(docker images -q --filter "dangling=true")
if [ "$value" = "" ]; then
	echo "No Dangling Images"
else
	echo "Removing Dangling Images"
 	docker images -q --filter "dangling=true" | xargs docker rmi
fi
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