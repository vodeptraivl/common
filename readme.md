docker build
docker stop commonApp || true && docker rm commonApp || true && docker image rm commonapp || true && docker build -t commonapp . && docker run -it -d -p 1111:8080 --name commonApp