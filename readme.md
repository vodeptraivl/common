docker build
docker stop commonApp && docker rm commonApp && docker image rm commonapp && docker build -t commonapp . && docker run -it -d -p 1111:8080 --name commonApp