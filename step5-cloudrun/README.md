# Workshop Serverless for your startup - Cloud Run

An App Engine Standard demo app using Java 8, Maven, and Objectify.

Step 1: just the base Hello World project

## Running Locally using npm

1. `npm install`
2. `npm start`

cloudshell edit Dockerfile

## Running Locally using Docker

1. `docker build . -t nodetime -f Dockerfile`
2. `docker run -d nodetime`

## Deploying

1. `gcloud builds submit --tag gcr.io/workshop-devfest-baku/nodetime`
2. `gcloud run deploy --image gcr.io/workshop-devfest-baku/nodetime`

## Domain mapping

Optional - will be demoed