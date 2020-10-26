# prodShop

To deploy application on your host use:

kubectl create -f mediator-deployment.yaml,mediator-service.yaml

To check if it works correctly, use this to forward port from mediator pod (name of pod you should get by command "kubectl get pods")

kubectl port-forward mediator-79dcd7b49f-4lr7j 8081:8081

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
