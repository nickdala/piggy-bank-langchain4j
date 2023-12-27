# Piggy Bank LangChain for Java

`Piggy Bank` is a simple AI driven banking application using [OpenAI](https://openai.com/), [LangChain4j](https://github.com/langchain4j/langchain4j) and [Spring Boot with React](https://hilla.dev/) :rocket:.

`Piggy Bank` is written in Java using [Hilla](https://hilla.dev/). The Hilla web framework was chosen because it brings together the power of Spring Boot and React. It allows you to build a full stack web application with a single codebase.

## Requirements

To keep things simple, the application covers the following use cases.

- A *Bank Associate* can see a list of customers
- A *Bank Associate* can click on a customer to see their accounts
- Accounts can either be *Opened* or *Closed*

Finally, we'll integrate **OpenAI's GPT-3 API** to allow a customer to close their account through an **AI driven chatbot**.

## Prerequisites

### Generate an OpenAI API Key

You will need to create an OpenAI API key to run the application. You can create a *secret API key* [here](https://platform.openai.com/api-keys).

1. Click on the `API keys` link.
    ![openai-api-key](./assets/openai-api-key.png)
1. Click on the `Create new secret key` button.
    ![openai-api-key-create](./assets/openai-api-key-create.png)
1. Give the secret key a name.
1. Click on the `Create secret key` button.
1. Copy the API key.
    ![openai-api-key-secret](./assets/openai-api-key-secret.png)

## Build & Deploy

The easiest way to build the sample is to use GitHub CodeSpaces. You can also use dev container to build the sample locally or use your own development environment.

To build the sample using CodeSpaces, follow the steps below.

1. Navigate to the GitHub repository [nickdala/piggy-bank-langchain4j](https://github.com/nickdala/piggy-bank-langchain4j)
1. Click on the `Code` button.
1. Click on the `Codespaces` tab.
1. Click on the `Create codespace on main` button.

![open-with-codespaces](./assets/open-with-codespaces.png)

This will create a GitHub Codespace and clone the repository. Once the Codespace is ready, you will see the following.

![codespace-ready](./assets/codespace-ready.png)

### Local Development (Optional)

You can also use your own development environment to run the application. Below are the requirements for your development environment according to [Hilla](https://hilla.dev/docs/react/start/basics#requirements).

- Java 17 or later
- Node 18 or later
- An IDE that supports Java and TypeScript — IntelliJ Ultimate and VS Code are good choices

To run the application locally, clone the repository and change directory

```bash
git clone https://github.com/nickdala/piggy-bank-langchain4j.git

cd piggy-bank-langchain4j
```

### Set the OpenAI API Key

Next, we need to set the OpenAI API key in the `application.properties` file. To do this, navigate to `src/main/resources/application.properties` and set the property `langchain4j.chat-model.openai.api-key`.

![application-properties](./assets/application-properties.png)

### Build and Run the application

To build and run the application, run the following command in the CodeSpaces terminal.

```bash
./mvnw
```

This will build and run the application. A new browser window will launch automatically with the **Piggy Bank** application.

Here is the UI of what the application looks like.

![piggy-bank](./assets/piggy-bank.png)

## Closing an account with an AI driven chatbot

To close an account, click on the `Chat` menu. This will launch an AI driven chatbot. The chatbot will ask you a series of questions to close the account.

Here is a sample conversation with the chatbot looks like.

![piggy-bank-chatbot](./assets/piggy-bank-chatbot.png)

Provide the chatbot with the id of the account you want to close. Once the account is closed, verify this in the UI.

Pretty cool, right? :sunglasses:

## Getting started with LangChain4j

Lets now take a look at how we incorporate [LangChain4j](https://github.com/langchain4j/langchain4j) into your application.

### Maven Dependency

The first step is to add the LangChain4j dependency to your `pom.xml` file of your Spring Boot application.

```xml
<dependency>
  <groupId>dev.langchain4j</groupId>
  <artifactId>langchain4j-spring-boot-starter</artifactId>
  <version>0.24.0</version>
</dependency>
```

### Include OpenAI API Key in application.properties

Next, we need to set the OpenAI API key in the `application.properties` file. To do this, navigate to `src/main/resources/application.properties` and set the property `langchain4j.chat-model.openai.api-key`.

```properties
langchain4j.chat-model.openai.api-key=<your-openai-api-key>
```



## Local Setup

### 1. Clone the repository and change directory

```bash
git clone https://github.com/nickdala/piggy-bank-langchain4j.git

cd piggy-bank-langchain4j
```

### 2. Build and Run the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux).

Build the project and run the application using the following command:

```bash
./mvnw clean package
```

Now run the app by executing the following command.

```bash
./mvnw
```

Then open [http://localhost:8080](http://localhost:8080) in your browser.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).

```bash
./mvnw clean package -Pproduction
```

This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar` (NOTE, replace
`myapp-1.0-SNAPSHOT.jar` with the name of your jar).

## Project structure

<table style="width:100%; text-align: left;">
  <tr><th>Directory</th><th>Description</th></tr>
  <tr><td><code>frontend/</code></td><td>Client-side source directory</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.html</code></td><td>HTML template</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.ts</code></td><td>Frontend 
entrypoint, bootstraps a React application</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>routes.tsx</code></td><td>React Router routes definition</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>MainLayout.tsx</code></td><td>Main 
layout component, contains the navigation menu, uses <a href="https://hilla.dev/docs/react/components/app-layout">
App Layout</a></td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>views/</code></td><td>UI view 
components</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>themes/</code></td><td>Custom  
CSS styles</td></tr>
  <tr><td><code>src/main/java/&lt;groupId&gt;/</code></td><td>Server-side 
source directory, contains the server-side Java views</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>Application.java</code></td><td>Server entry-point</td></tr>
</table>

## Useful links

- Read the documentation at [hilla.dev/docs](https://hilla.dev/docs/).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/hilla) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin/hilla).
