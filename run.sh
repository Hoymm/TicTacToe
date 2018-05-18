#!/bin/bash
mvn clean install
java -jar target/TicTacToe-1.3.jar $1
