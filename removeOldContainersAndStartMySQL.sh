docker rm -vf $(docker ps -aq)
docker volume rm $(docker volume ls -q)
docker rmi -f $(docker images -aq)
docker build -t foo . && docker run -it -p 3306:3306 foo