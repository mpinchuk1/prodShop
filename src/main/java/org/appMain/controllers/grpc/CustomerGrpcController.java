package org.appMain.controllers.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.appMain.*;

@GrpcService
public class CustomerGrpcController extends customerServiceGrpc.customerServiceImplBase {

    private static final String URL = "customerservice";
    private static final int PORT = 9093;

    @Override
    public void get(GetCustomerRequest request, StreamObserver<GetCustomerResponse> responseStreamObserver) {
        System.out.println("Customers LOG");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(URL, PORT)
                .usePlaintext()
                .build();
        customerServiceGrpc.customerServiceBlockingStub stub = customerServiceGrpc.newBlockingStub(channel);
        GetCustomerResponse response = stub.get(request);
        channel.shutdown();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }

    @Override
    public void create(CreateCustomerRequest request, StreamObserver<CreateCustomerResponse> responseObserver) {
        System.out.println("Customer Create LOG");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(URL, PORT)
                .usePlaintext()
                .build();
        customerServiceGrpc.customerServiceBlockingStub stub = customerServiceGrpc.newBlockingStub(channel);
        CreateCustomerResponse response = stub.create(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}