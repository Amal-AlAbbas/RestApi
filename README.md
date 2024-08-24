# REST API File Data Reader

This project is a REST API service built using Liferay 7.3. It allows users to query and retrieve data from files stored in a specified directory on the server. The service is designed to be easily integrated with various clients, including Postman for testing and development purposes.

## Project Structure

- **FileDataHandler.java**: Contains the core logic for reading data from files. This class processes file paths and handles any I/O operations needed to retrieve the content.
- **FileDataHandlerServiceImpl.java**: Implements the service interface, coordinating between the API request and the file handling logic.
- **SampleApplication.java**: The main entry point of the application, setting up the RESTful API and configuring routes for handling requests.
- **bnd.bnd**: The configuration file for the OSGi bundle, specifying the package version, dependencies, and other bundle metadata.
- **Sample.iml**: IntelliJ project file that manages project-specific settings, such as module configurations and libraries.

## Setup Instructions

### Prerequisites

- Java 8 or higher
- Liferay 7.3
- IntelliJ IDEA (optional but recommended for development)
- Git

### Cloning the Repository

To clone the repository, run the following command:

```bash
git clone https://github.com/username/repository.git
