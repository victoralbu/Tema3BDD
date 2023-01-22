#FROM mysql
#
#MAINTAINER me
#
#ADD script.sql /docker-entrypoint-initdb.d
#
#EXPOSE 3382

#FROM postgres:14.1-alpine
#ENV POSTGRES_DB info_warn
#COPY script.sql /docker-entrypoint-initdb.d/