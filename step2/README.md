# MVP Product Landing Page - Step 2

An App Engine Standard demo app using Java 8, Maven, and Objectify.

Step 2: Let's add the Contact entity persistence in the Cloud Datastore,
and a small web form to register as a JSP.
We are adding as well an overly simple junit unit test.

## Running Locally

1. `mvn clean package`
2. `mvn appengine:run`

## Deploying

1. `mvn appengine:deploy`