# prometheus-stack-example-project

Example of how a Prometheus alerting stack could look with a Java web service to simulate a real world target. 


Stack contains
  * Prometheus
  * AlertManager
  * Grafana
  * Example of target service
  
  
  To run the services:
  
  ```./gradlew assemble docker dockerTagLatest dockerComposeUp ```
  
  To stop the services:
  
  ```./gradlew dockerComposeDown```
