package com.kfreemarket.reemarket_server.domain.order.entity;

import com.kfreemarket.reemarket_server.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class OrderItem {

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @CreatedDate
    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(
            name = "OrderItemOption",
            joinColumns = @JoinColumn(name = "order_item_id")
    )
    @Column(name = "option_value", nullable = false)
    private List<String> optionLists = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @Builder
    public OrderItem(Integer quantity, Orders orders, Product product, List<String> optionLists) {
        this.quantity = quantity;
        this.orders = orders;
        this.optionLists = optionLists;
    }
}
