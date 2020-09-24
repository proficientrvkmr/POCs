# SAM DynamoDB Application for Managing Orders

This is a sample application to demonstrate how to build an application on DynamoDB using the
DynamoDBMapper ORM framework to map Order items in a DynamoDB table to a RESTful API for order
management.


### Installing dependencies

We use `maven` to install our dependencies and package our application into a JAR file:

```bash
mvn package
```

### Local development

**Invoking function locally through local API Gateway**
1. Start DynamoDB Local in a Docker container. `docker run -p 8000:8000 amazon/dynamodb-local`
2. Create the DynamoDB table. `aws dynamodb create-table --table-name orders_table --attribute-definitions AttributeName=orderId,AttributeType=S --key-schema AttributeName=orderId,KeyType=HASH --billing-mode PAY_PER_REQUEST --endpoint-url http://localhost:8000`
3. Start the SAM local API.
 - On a Mac: `sam local start-api --env-vars src/test/resources/test_environment_mac.json`
 - On Windows: `sam local start-api --env-vars src/test/resources/test_environment_windows.json`
 - On Linux: `sam local start-api --env-vars src/test/resources/test_environment_linux.json`

If the previous command ran successfully you should now be able to hit the following local endpoint to
invoke the functions rooted at `http://localhost:3000/orders`

**SAM CLI** is used to emulate both Lambda and API Gateway locally and uses our `template.yaml` to
understand how to bootstrap this environment (runtime, where the source code is, etc.) - The
following excerpt is what the CLI will read in order to initialize an API and its routes:

```yaml
...
Events:
    GetOrders:
        Type: Api # More info about API Event Source: https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md#api
        Properties:
            Path: /orders
            Method: get
```

## Packaging and deployment

AWS Lambda Java runtime accepts either a zip file or a standalone JAR file - We use the latter in
this example. SAM will use `CodeUri` property to know where to look up for both application and
dependencies:

```yaml
...
    GetOrdersFunction:
        Type: AWS::Serverless::Function
        Properties:
            CodeUri: target/aws-sam-java-rest-1.0.0.jar
            Handler: com.amazonaws.handler.GetOrdersHandler::handleRequest
```

Firstly, we need a `S3 bucket` where we can upload our Lambda functions packaged as ZIP before we
deploy anything - If you don't have a S3 bucket to store code artifacts then this is a good time to
create one:

```bash
export BUCKET_NAME=my_cool_new_bucket
aws s3 mb s3://$BUCKET_NAME
```

Next, run the following command to package our Lambda function to S3:

```bash
sam package \
    --template-file template.yaml \
    --output-template-file packaged.yaml \
    --s3-bucket $BUCKET_NAME
```

Next, the following command will create a Cloudformation Stack and deploy your SAM resources.

```bash
sam deploy \
    --template-file packaged.yaml \
    --stack-name sam-orderHandler \
    --capabilities CAPABILITY_IAM
```

> **See [Serverless Application Model (SAM) HOWTO Guide](https://github.com/awslabs/serverless-application-model/blob/master/HOWTO.md) for more details in how to get started.**

After deployment is complete you can run the following command to retrieve the API Gateway Endpoint URL:

```bash
aws cloudformation describe-stacks \
    --stack-name sam-orderHandler \
    --query 'Stacks[].Outputs'
```

## Testing

### Running unit tests
We use `JUnit` for testing our code.
Unit tests in this sample package mock out the DynamoDBTableMapper class for Order objects.
Unit tests do not require connectivity to a DynamoDB endpoint. You can run unit tests with the
following command:

```bash
mvn test
```

### Running integration tests
Integration tests in this sample package do not mock out the DynamoDBTableMapper and use a real
AmazonDynamoDB client instance. Integration tests require connectivity to a DynamoDB endpoint, and
as such the POM starts DynamoDB Local from the Dockerhub repository for integration tests.

```bash
mvn verify
```


## AWS CLI commands

AWS CLI commands to package, deploy and describe outputs defined within the cloudformation stack:

```bash
sam package --template-file template.yaml --output-template-file packaged.yaml --s3-bucket REPLACE_THIS_WITH_YOUR_S3_BUCKET_NAME

sam deploy --template-file packaged.yaml --stack-name sam-orderHandler --capabilities CAPABILITY_IAM --parameter-overrides MyParameterSample=MySampleValue

aws cloudformation describe-stacks --stack-name sam-orderHandler --query 'Stacks[].Outputs'
```

## Bringing to the next level

Next, you can use the following resources to know more about beyond hello world samples and how others
structure their Serverless applications:

* [AWS Serverless Application Repository](https://aws.amazon.com/serverless/serverlessrepo/)
