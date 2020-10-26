# prodShop

To deploy application use:

kubectl create -f mediator-deployment.yaml,mediator-service.yaml

Use this command to forward port from mediator pod (use command to get pod name "kubectl get pods")

kubectl port-forward mediator 8081:8081

1. CourierController:
  Post("/supply/deliverProducts")

2. CustomerController:
  Get("/customers/getAll")
  
3. OrderController:
  Post("/orders/create")
  Get("/orders/getAll")
  
4. ProductsController:
  Get("/products/getAll")
  
5. ShopController:
  Get("/shop/filterExpiredProducts")
