package org.appMain.controllers.grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.appMain.*;

@GrpcService
public class SupplierGrpcController extends supplierServiceGrpc.supplierServiceImplBase {

    private static final String URL = "courierservice";
    private static final int PORT = 9092;

    @Override
    public void getProducts(GetRequestProduct request, StreamObserver<GetResponseProduct> responseStreamObserver) {
        System.out.println("getProducts LOG");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(URL, PORT)
                .usePlaintext()
                .build();
        supplierServiceGrpc.supplierServiceBlockingStub stub = supplierServiceGrpc.newBlockingStub(channel);
        GetResponseProduct response = stub.getProducts(request);
        channel.shutdown();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }

    @Override
    public void deliverProducts(DeliverProductsRequest request, StreamObserver<DeliverProductsResponse> responseObserver) {
        System.out.println("deliverProducts LOG");

        ManagedChannel channel = ManagedChannelBuilder.forAddress(URL, PORT)
                .usePlaintext()
                .build();
        supplierServiceGrpc.supplierServiceBlockingStub stub = supplierServiceGrpc.newBlockingStub(channel);
        DeliverProductsResponse response = stub.deliverProducts(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}