mvn clean package
sam package --template-file template.yaml --output-template-file packaged.yaml --s3-bucket aws-develop-test
sam deploy --template-file packaged.yaml --stack-name helloWorldLambdaDeployStack --capabilities CAPABILITY_IAM
aws cloudformation describe-stacks --stack-name helloWorldLambdaDeployStack