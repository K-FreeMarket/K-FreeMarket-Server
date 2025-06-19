package com.kfreemarket.reemarket_server.global.enums;

public enum OrderStatus {
    PREPARING, // 주문 접수 및 상품 준비 중
    SHIPPING, // 상품이 배송 중
    DELIVERED, // 상품이 고객에게 배송 완료
    RETURN_PROCESSING, // 반송 또는 방품 처리 중
    COMPLETED // 모든 처리 완료(구메 확정, 반품 완료 등)

}
