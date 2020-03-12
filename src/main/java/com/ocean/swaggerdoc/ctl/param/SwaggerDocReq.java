package com.ocean.swaggerdoc.ctl.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * SwaggerDocReq请求
 *
 * @author oceanBin on 2020/3/11
 */
@Data
@ApiModel(description = "swagger to doc req-params")
public class SwaggerDocReq {
    @ApiModelProperty(value = "含义：待导出swagger-api地址；" , required = true, example = "http://10.0.41.235:8080/v2/api-docs")
    @Pattern(regexp = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+(\\\\?{0,1}(([A-Za-z0-9-~]+\\\\={0,1})([A-Za-z0-9-~]*)\\\\&{0,1})*)$")
    private String url;

    @ApiModelProperty(value = "含义：导出文件类型；" , required = true, example = "Markdown")
    private DocType docType;
}
