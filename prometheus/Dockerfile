FROM prom/prometheus:latest

ADD prometheus.yml /etc/prometheus
ADD general.rules.yml /etc/prometheus

# Change to root to set folder permissions
USER root
RUN chmod -R 700 /etc/prometheus
RUN chown -R nobody:nobody /etc/prometheus

# Best practice to return to lower privileged user
USER nobody