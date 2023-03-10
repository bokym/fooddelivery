package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class CookStarted extends AbstractEvent {

    private Long id;
    private String foodId;
    private String preference;
    private Long orderId;
    private String status;
    private String address;
}
