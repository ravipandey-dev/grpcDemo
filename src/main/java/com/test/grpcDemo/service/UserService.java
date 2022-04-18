package com.test.grpcDemo.service;

import com.test.grpcDemo.User.Response;
import com.test.grpcDemo.User.Empty;
import com.test.grpcDemo.User.LoginRequest;
import com.test.grpcDemo.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService extends userImplBase {
     private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    public void login(LoginRequest request, StreamObserver<Response> responseObserver) {
        logger.info("login request recieved");
        String user = request.getUsername();
        String password = request.getPassword();

        Response.Builder response = Response.newBuilder();

        if("RAVI".equals(user)){
            response.setResponseCode(200);
            response.setResponsemessage("Login Success");
        }else{
            response.setResponseCode(401);
            response.setResponsemessage("Invalid Username or password");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<Response> responseObserver) {

    }
}
