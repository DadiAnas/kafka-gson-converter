# kafka-gson-converter

## Introduction 
In this section I will show you how to test this project on your own environement. 
Before starting, I want to talk a little about the structer of this project, you will find a:
  1.Product model with fileds : `name` and `price`, you can use any other model later.
  2. A simple kafka controller to send post request to `productTopic` kafka topic.
  3. A kafkaConfig class for configuration, here where we used Gson class (Google json) in order to be able to serialize and deserialize most used types in a generic way.
 
## Set up environement

First of all you have to download kafka, and then go to kafka folder to run Zookeeper and kafka.

1. go to kafka folder:
  `cd path/to/kafka`
2. Run Zookeeper:
  `./bin/zookeeper-server-start.sh ./config/zookeeper.properties`
3. Run kafka:
  `./bin/kafka-server-start.sh ./config/server.properties`
 
After runing kafka successefely, clone the project with git `git clone https://github.com/DadiAnas/kafka-gson-converter` or just download it.
Open this spring initializer project with your preferable IDLE and run it.

## Test the project

Here we go, if everything works well, now you can send post request to the endpoint `api/kafka`, if you are working on localhost it may looks like this
`http://localhost:8080/api/kafka`.
An example of body request: `{"name":"product1","price":125.0}`.

If everything works fine, you will see the sent json in the debug console. 
Otherwise, you can use a kafka console consumer to see it directly by executing this command in a commandline in kafka folder:
`./bin/kafka-console-consumer.sh --topic productTopic --bootstrap-server localhost:9092`.
