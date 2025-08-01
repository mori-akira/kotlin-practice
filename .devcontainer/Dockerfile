FROM eclipse-temurin:17-jdk-jammy

# Set environment variables for Kotlin and Gradle/Maven (if using)
ENV KOTLIN_VERSION=1.9.23
ENV GRADLE_VERSION=8.8

# Install necessary tools and dependencies
RUN apt-get update && apt-get install -y \
    curl \
    zip \
    unzip \
    git

# Install Kotlin (e.g., using SDKMAN! or manual download)
RUN curl -s "https://get.sdkman.io" | bash \
    && bash -c "source \"$HOME/.sdkman/bin/sdkman-init.sh\" && sdk install kotlin ${KOTLIN_VERSION}" \
    && bash -c "source \"$HOME/.sdkman/bin/sdkman-init.sh\" && sdk install gradle ${GRADLE_VERSION}"

# Create a non-root user for development (recommended for security)
ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=1000
RUN groupadd --gid $USER_GID $USERNAME \
    && useradd -s /bin/bash --uid $USER_UID --gid $USER_GID -m $USERNAME \
    && usermod -aG sudo $USERNAME

# Set the working directory
WORKDIR /workspace

# Switch to the non-root user
USER $USERNAME
