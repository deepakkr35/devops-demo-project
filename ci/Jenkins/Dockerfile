# Dockerfile

FROM jenkins/jenkins:lts-jdk17

# Switch to root to install Maven and Docker
USER root

# Install Maven
RUN apt-get update && apt-get install -y maven

# Install Docker
RUN apt-get update && \
    apt-get install -y \
    ca-certificates \
    curl \
    sudo && \
    curl -fsSL https://get.docker.com -o install-docker.sh && \
    sudo sh install-docker.sh && \
    sudo usermod -a -G docker jenkins

# Expose Jenkins port
EXPOSE 8080