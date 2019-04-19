package com.gui.star_compute_service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "订单信息")
public class BuyOrders {
    @ApiModelProperty(value = "商品ID")
    private int good_id;

    @ApiModelProperty(value = "订单ID")
    private int order_id;

    @ApiModelProperty(value = "用户ID")
    private int user_id;
}
