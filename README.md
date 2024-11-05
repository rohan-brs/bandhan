# Order Processing with Camunda and Spring Boot

A Spring Boot microservice designed for order processing, using Camunda BPMN to orchestrate workflows and a DMN decision table to determine shipment types.

## Project Overview

The microservice performs the following tasks:
  * Validates incoming order requests.
  * Starts an order process using a BPMN workflow.
  * A DMN decision table is used to decide the shipment type based on business rules.
  * Manages order and inventory records in a SQL database.
  
## Features

- **REST API**: `POST /api/v1/order/process` to process orders and start a bpmn process.
- **Camunda BPMN Workflow**: Handles the order processing steps.
- **Custom Validation**: Ensures request data is correct before processing.
- **Postgres SQL**: To store customer, order and inventory records.
