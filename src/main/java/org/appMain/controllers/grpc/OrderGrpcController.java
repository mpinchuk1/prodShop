package org.appMain.controllers.grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.appMain.*;

@GrpcService
public class OrderGrpcController extends orderServiceGrpc.orderServiceImplBase {

    private static final String URL = "orderservice";
    private static final int PORT = 9094;

    @Override
    public void getOrders(GetRequestOrder request, StreamObserver<GetResponseOrder> responseStreamObserver) {
        System.out.println("GET Orders LOG");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(URL, PORT)
                .usePlaintext()
                .build();
        orderServiceGrpc.orderServiceBlockingStub stub = orderServiceGrpc.newBlockingStub(channel);
        GetResponseOrder response = stub.getOrders(request);
        channel.shutdown();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }

    @Override
    public void getOrderedThing(GetRequestOrderedProduct request, StreamObserver<GetResponseOrderedProduct> responseStreamObserver) {
        System.out.println("GET Orders Things LOG");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(URL, PORT)
                .usePlaintext()
                .build();
        orderServiceGrpc.orderServiceBlockingStub stub = orderServiceGrpc.newBlockingStub(channel);
        GetResponseOrderedProduct response = stub.getOrderedThing(request);
        channel.shutdown();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }

    @Override
    public void create(CreateOrderRequest request, StreamObserver<CreateOrderResponse> responseObserver) {
        System.out.println("Create order LOG");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(URL, PORT)
                .usePlaintext()
                .build();
        orderServiceGrpc.orderServiceBlockingStub stub = orderServiceGrpc.newBlockingStub(channel);
        CreateOrderResponse response = stub.create(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}