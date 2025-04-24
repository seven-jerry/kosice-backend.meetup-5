FROM --platform=linux/amd64 docker.io/bitnami/java:21
RUN apt-get update && apt-get install -y unzip && rm -rf /var/lib/apt/lists/*
ADD ./contents /contents
WORKDIR /contents
RUN cd /contents && ls -la && chmod +x entrypoint.sh

ENTRYPOINT ./entrypoint.sh

# docker run --rm -e "JAVA_OPTIONS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" --name microservice -p 8080:8080 -p 5005:5005 -e "UNPACK_JAR=true" myapp