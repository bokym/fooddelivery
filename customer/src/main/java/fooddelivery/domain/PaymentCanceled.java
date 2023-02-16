package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String payMethod;
    private Integer amount;
    private String status;
}
