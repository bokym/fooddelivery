package fooddelivery.domain;

import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.OrderCanceled;
import fooddelivery.OrdernpayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private String options;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private Long storeId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();
        // mappings goes here
        OrdernpayApplication.applicationContext.getBean(fooddelivery.external.PaymentService.class)
            .pay(payment);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }
    @PreUpdate
    public void onPreUpdate(){
        // Get request from StoreOrder
        //fooddelivery.external.StoreOrder storeOrder =
        //    Application.applicationContext.getBean(fooddelivery.external.StoreOrderService.class)
        //    .getStoreOrder(/** mapping value needed */);

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrdernpayApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void updateStatus(Accepted accepted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(Rejected rejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(CookStarted cookStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
