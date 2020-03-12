package com.ocean.swaggerdoc.ctl.demo;

import com.ocean.swaggerdoc.ctl.demo.param.DemoReq;
import com.ocean.swaggerdoc.ctl.demo.param.DemoRsp;
import com.ocean.swaggerdoc.ctl.param.SwaggerDocReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * 示例
 *
 * @author oceanBin on 2020/3/12
 */

@RestController
@Api("示例接口")
@RequestMapping("/demo")
@Slf4j
public class DemoCtl {

    @ApiOperation(value = "导出swagger接口文档", notes = "导出swagger接口文档")
    @PostMapping(value = "/out")
    public DemoRsp swagger2doc(@RequestBody @ApiParam(value = "请求参数", required = true) DemoReq reqParam) {
        boolean isVip = reqParam.getAge() % 2 == 0;
        return DemoRsp.builder().name(reqParam.getName()).age(reqParam.getAge()).isVip(isVip).build();
    }
}
