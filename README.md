# Assignment-2
# Device Log Analyzer

## Description

Device Log Analyzer is a console-based Java application that reads
device log records, validates them, handles malformed records, and
provides different analysis operations.

## Features

1. List all records
2. Count records by status code
3. Find records by device ID
4. Show earliest and latest timestamps
5. Handle invalid records using a custom exception

## Java Concepts Used

- Classes and objects
- Encapsulation
- Constructors
- ArrayList
- If-else
- Switch statement
- For loop
- Enhanced for loop
- While loop
- Try-catch-finally
- Custom checked exception

## Compile

javac -d out src/*.java

## Run

java -cp out Main

## Sample Data

The data/logs.txt file contains valid and malformed device records.

Malformed records are skipped and an error message is displayed.
