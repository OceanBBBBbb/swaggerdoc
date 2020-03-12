package com.ocean.swaggerdoc.ctl.demo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * DemoRsp
 *
 * @author oceanBin on 2020/3/12
 */
@Data
@Builder
public class DemoRsp {

    @ApiModelProperty(value = "含义：姓名；" , required = true, example = "张三")
    private String name;
    @ApiModelProperty(value = "含义：年龄；" , required = true, example = "21")
    private int age;
    @ApiModelProperty(value = "含义：是会员吗；" , required = true, example = "true")
    private boolean isVip;

}
