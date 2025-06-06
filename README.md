PCD a.y. 2024-2025 - ISI LM UNIBO - Cesena Campus

# Lab Activity #10 - 20250606

v.1.0.0-20250605

 
### Distributed Object Computing -  Java RMI

- [Java Remote Method Invocation](https://www.oracle.com/java/technologies/javase/remote-method-invocation-home.html)
    - [Java Remote Method Invocation Distributed Computing for Java](https://www.oracle.com/java/technologies/javase/remote-method-invocation-distributed-computing.html)
    - [Jim Waldo on Java RMI's](https://pdos.csail.mit.edu/6.824/papers/waldo-rmi.pdf)
   - [Java RMI Hello World](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/hello/hello-world.html)
- Examples in ``pcd.lab10.rmi``
  - Before running the examples, launch the RMI middleware on localhost by running ``rmiregistry``. **The registry needs to access the classpath including the ``*.class`` of remote objects accessed**. The simplest way to do this is to run ``rmiregistry`` from the classpath directory (``lab10/target/classes``).  
  - First example `pcd.lab10.rmi.example_01` 
    - Server side (`RunServerSide`)  
	  - Remote objects => instances of class implementing interface ``Remote``  
        - **every remote method must throw ``RemoteException``**
      - Publishing (exporting) remote objects on a note with a name by the Registry  
	- Client side (`RunClientSide`)  
      - Lookup remote objects  
      - Call remote method with args  
      - Passing parameters by value (serialized)  
    - Control flow analysis  
      - Which control architecture? Concurrency? Races?  
  - Second example `pcd.lab10.rmi.example_02`   
    - Pattern observer with remote listeners
      - Passing parameters by reference (remote objects)     

### Message-Oriented Middlewares for Distributed Computing

- Interoperable Message Passing and Message-Oriented Middleware (MOM)  
  -  module-lab-4.2 - Message Oriented Middlewares (MOM)  
    - [RabbitMQ](http://www.rabbitmq.com)  
- Examples in ``pcd.lab10.rabbitmq``
  - Using [Rabbit MQ in Java](https://www.rabbitmq.com/java-client.html), based on [client side tutorials](https://www.rabbitmq.com/tutorials)
  - Before running the examples: [install and run RabbitMQ middleware on localhost](https://www.rabbitmq.com/docs/download)
    - quickest way: through Docker  
      ``docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management``
