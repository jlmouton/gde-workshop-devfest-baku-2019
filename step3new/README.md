# MVP Product Landing Page - Step 3

An App Engine Standard demo app using Java 8, Maven, and Objectify.

Step 3: Let's make things pretty with a web page template
We will just wrap the step 2 form with a web template before this can go to production
For this demo, we use https://colorlib.com/wp/template/cargo/

## Running Locally

1. `mvn clean package`
2. `mvn appengine:run`

## Deploying

1. `mvn appengine:deploy`