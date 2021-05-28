# SpringBootDemo

# is for deploy on azure
You’re now in the production slot, which is not recommended for setting up CI/CD.Learn more
Deploy and build code from your preferred source and build provider. Learn more

Source*
Building with GitHub Actions.Change provider.
GitHub
If you can’t find an organization or repository, you may need to enable additional permissions on GitHub. Learn more

Signed in as
pankaj488Change Account
Organization*
pankaj488
Repository*
SpringBootDemo
Branch*
main
Build
Runtime stack*
Version*
Workflow Configuration
File with the workflow configuration defined by the settings above.


Workflow Configuration
File path: .github/workflows/main_pankajspringboot.yml

If an existing workflow configuration exists, it will be overwritten.
# Docs for the Azure Web Apps Deploy action: https://github.com/Azure/webapps-deploy
# More GitHub Actions for Azure: https://github.com/Azure/actions

name: Build and deploy JAR app to Azure Web App - pankajspringboot

on:
push:
branches:
- main
workflow_dispatch:

jobs:
build:
runs-on: ubuntu-latest

steps:
- uses: actions/checkout@v2

- name: Set up Java version
uses: actions/setup-java@v1
with:
java-version: '8'

- name: Build with Maven
run: mvn clean install

- name: Upload artifact for deployment job
uses: actions/upload-artifact@v2
with:
name: java-app
path: '${{ github.workspace }}/target/*.jar'

deploy:
runs-on: ubuntu-latest
needs: build
environment:
name: 'production'
url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}

steps:
- name: Download artifact from build job
uses: actions/download-artifact@v2
with:
name: java-app

- name: Deploy to Azure Web App
id: deploy-to-webapp
uses: azure/webapps-deploy@v2
with:
app-name: 'pankajspringboot'
slot-name: 'production'
publish-profile: ${{ secrets.AzureAppService_PublishProfile_c63e1211245f43c788a850fa7aa4d599 }}
package: '*.jar'
