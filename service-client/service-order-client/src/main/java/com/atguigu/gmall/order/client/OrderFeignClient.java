package com.atguigu.gmall.order.client;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.order.OrderInfo;
import com.atguigu.gmall.order.client.impl.OrderDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author mqx
 * @date 2020/5/4 15:34
 */
@FeignClient(name = "service-order",fallback = OrderDegradeFeignClient.class)
public interface OrderFeignClient {

    // 远程调用
    @GetMapping("api/order/auth/trade")
    Result<Map<String,Object>> trade();

    // 根据orderId 查询订单数据
    @GetMapping("/api/order/inner/getOrderInfo/{orderId}")
    OrderInfo getOrderInfo(@PathVariable(value = "orderId") Long orderId);
    @PostMapping("/api/order/inner/seckill/submitOrder")
    Long submitOrder(OrderInfo orderInfo);
}
