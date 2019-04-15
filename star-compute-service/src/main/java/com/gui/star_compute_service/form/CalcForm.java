package com.gui.star_compute_service.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "封装的计算对象信息")
public class CalcForm {
    @ApiModelProperty(value = "第一个数字")
    private Integer a;

    @ApiModelProperty(value = "第二个数字")
    private Integer b;
}
