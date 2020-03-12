package com.ocean.swaggerdoc.ctl.demo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DemoReq
 *
 * @author oceanBin on 2020/3/12
 */
@Data
@ApiModel(description = "示例的接口请求参数")
public class DemoReq {

    @ApiModelProperty(value = "含义：姓名；" , required = true, example = "张三")
    private String name;
    @ApiModelProperty(value = "含义：年龄；" , required = true, example = "21")
    private int age;

}
