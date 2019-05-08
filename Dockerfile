FROM gradle:5.4
ADD . /srv
WORKDIR /srv
USER root
RUN gradle build
CMD ["gradle", "--stacktrace", "run"]