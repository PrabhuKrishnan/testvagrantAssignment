FROM prabhukrishnan/apiframework-jdk-11-maven-3.8.6
COPY src  home/apiframework/src
COPY test-output  home/apiframework/test-output
COPY pom.xml	home/apiframework/pom.xml
COPY testng.xml	home/apiframework/testng.xml
COPY index.html home/apiframework/index.html
WORKDIR home/apiframework
ENTRYPOINT mvn test -Pregression