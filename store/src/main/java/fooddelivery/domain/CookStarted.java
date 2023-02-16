package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String foodId;
    private String preference;
    private Long orderId;
    private String status;
    private String address;

    public CookStarted(StoreOrder aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
