FROM --platform=linux/amd64 redhat/ubi8:latest

USER 0
COPY ./extensions.zip /tmp/


RUN mkdir -p /opt/app-root/src/.local/share/code-server/extensions

RUN  yum install -y java-21-openjdk-devel && \
     yum install -y git && \
     yum install -y unzip && \
     yum install -y socat

RUN  groupadd --system --gid 1000650000 vscode && \
     useradd --system --uid 1000650000 --gid 1000650000 --no-create-home --home-dir /opt/app-root/src --shell /bin/bash vscode && \
     dnf module install -y nodejs:16/common &&\
     yum install -y python2 && \
     mkdir -p /opt/app-root/src/.config/code-server



RUN ls -la /tmp && mkdir /tmp/extensions && unzip /tmp/extensions.zip -d /tmp
RUN cp -R /tmp/extensions/* /opt/app-root/src/.local/share/code-server/extensions


COPY ./code-server.zip /
ADD config.yaml /opt/app-root/src/.config/code-server
RUN unzip /code-server.zip && ls -la / && chown -R 1000650000 /code-server 
RUN mkdir -p /opt/app-root && chown -R 1000650000 /opt/app-root && ls -la /code-server
ENTRYPOINT ["/code-server/bin/code-server"]
USER 1000650000