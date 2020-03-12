package com.ocean.swaggerdoc.ctl;

import com.ocean.swaggerdoc.core.Swagger2Doc;
import com.ocean.swaggerdoc.ctl.param.SwaggerDocReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.net.MalformedURLException;

/**
 * 主要的交互入口
 *
 * @author oceanBin on 2020/3/11
 */
@RestController
@Api("生成swagger文档接口")
@Slf4j
public class Swagger2DocCtl {


    @ApiOperation(value="导出swagger接口文档", notes="导出swagger接口文档")
    @PostMapping(value = "/out")
    public void swagger2doc(@RequestBody @ApiParam(value = "请求参数",required = true)SwaggerDocReq reqParam){
        String url = reqParam.getUrl();
        String pathName = url.replaceAll(":","").replaceAll("/","");
        try {
            switch (reqParam.getDocType()){
                case Markdown:Swagger2Doc.generateMarkdownDocsToFile(url,pathName);break;
                case Confluence:Swagger2Doc.generateConfluenceDocsToFile(url,pathName);break;
                case AsciiDocs:Swagger2Doc.generateAsciiDocsToFile(url,pathName);break;
            }
        } catch (MalformedURLException e) {
            log.error("无法访问的url:"+url,e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 生成后导出

    }

}
