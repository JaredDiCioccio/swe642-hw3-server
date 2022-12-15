FROM ubuntu:latest

RUN apt-get -y update
RUN apt-get -y install wget unzip
RUN apt-get install -y openjdk-17-jdk

RUN wget -q https://services.gradle.org/distributions/gradle-8.0-milestone-5-bin.zip \
    && unzip gradle-8.0-milestone-5-bin.zip -d /opt \
    && rm gradle-8.0-milestone-5-bin.zip

# Set Gradle in the environment variables
ENV GRADLE_HOME /opt/gradle-8.0-milestone-5
ENV PATH $PATH:/opt/gradle-8.0-milestone-5/bin

WORKDIR /opt/swe642-hw3-server-master
COPY . .

EXPOSE 8080
CMD ["gradle", "bootRun"]
