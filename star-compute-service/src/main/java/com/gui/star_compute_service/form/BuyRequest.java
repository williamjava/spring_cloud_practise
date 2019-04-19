package com.gui.star_compute_service.form;

import com.gui.star_compute_service.entity.BuyOrders;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "请求对象封装")
@Data
public class BuyRequest {
    @ApiModelProperty(value = "商品ID")
    private int good_id;

    @ApiModelProperty(value = "用户ID")
    private int user_id;

    @ApiModelProperty(value = "订单ID")
    private int order_id;

    @ApiModelProperty(value = "订单信息")
    private BuyOrders buyOrders;

    @ApiModelProperty(value = "0:未处理;1:正常;2:异常")
    private int response_status;
}