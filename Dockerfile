FROM gradle:5.4
ADD . /srv
WORKDIR /srv
USER root
CMD ["gradle", "--stacktrace", "run"]