package com.kfreemarket.reemarket_server.domain.order.entity;

import com.kfreemarket.reemarket_server.global.enums.PaymentStatus;
import com.kfreemarket.reemarket_server.global.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatusType;

    @Column(name = "paid_at", nullable = false)
    private LocalDateTime paidAt;

    @Column(name = "paid_price", nullable = false, length = 100)
    private Integer paidPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @Builder
    public Payment(PaymentType paymentType, PaymentStatus paymentStatusType, LocalDateTime paidAt, Integer paidPrice) {
        this.paymentType = paymentType;
        this.paymentStatusType = paymentStatusType;
        this.paidAt = paidAt;
        this.paidPrice = paidPrice;
    }

}
