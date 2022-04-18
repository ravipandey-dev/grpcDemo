package com.test.grpcDemo;

import com.test.grpcDemo.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcDemoApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		Logger logger=LoggerFactory.getLogger(GrpcDemoApplication.class);
		Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
		server.start();
		logger.info("GRPC Server started at {}" , server.getPort());
		server.awaitTermination();
		//SpringApplication.run(GrpcDemoApplication.class, args);

	}

}
