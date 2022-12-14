FROM ubuntu:latest
RUN apt-get -y update
RUN apt-get -y install git wget unzip
RUN apt-get install -y openjdk-17-jdk
#FROM openjdk:17-alpine
#install Gradle
RUN wget -q https://services.gradle.org/distributions/gradle-8.0-milestone-5-bin.zip \
    && unzip gradle-8.0-milestone-5-bin.zip -d /opt \
    && rm gradle-8.0-milestone-5-bin.zip

# Set Gradle in the environment variables
ENV GRADLE_HOME /opt/gradle-8.0-milestone-5
ENV PATH $PATH:/opt/gradle-8.0-milestone-5/bin

RUN git clone https://github.com/JaredDiCioccio/swe642-hw3-server application
RUN cd application
WORKDIR ./application
RUN gradle bootRun