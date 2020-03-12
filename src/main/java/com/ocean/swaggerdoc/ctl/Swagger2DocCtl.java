package com.ocean.swaggerdoc.ctl;

import com.ocean.swaggerdoc.core.AsyncJob;
import com.ocean.swaggerdoc.core.Swagger2Doc;
import com.ocean.swaggerdoc.ctl.param.SwaggerDocReq;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/**
 * 主要的交互入口
 *
 * @author oceanBin on 2020/3/11
 */
@RestController
@Api("生成swagger文档接口")
@Slf4j
public class Swagger2DocCtl {

    private final AsyncJob asyncJob;

    public Swagger2DocCtl(AsyncJob asyncJob) {
        this.asyncJob = asyncJob;
    }

    @ApiOperation(value = "导出swagger接口文档", notes = "导出swagger接口文档")
    @PostMapping(value = "/out")
    public ResponseEntity<InputStreamResource> swagger2doc(@RequestBody @ApiParam(value = "请求参数", required = true) SwaggerDocReq reqParam) throws IOException {
        String url = reqParam.getUrl();
        String fileName = url.replaceAll(":", "").replaceAll("/", "");
        MarkupLanguage markupLanguage;
        String fileSuffix;
        try {
            switch (reqParam.getDocType()) {
                case Confluence:
                    markupLanguage = MarkupLanguage.CONFLUENCE_MARKUP;
                    fileSuffix = ".txt";
                    break;
                case AsciiDocs:
                    markupLanguage = MarkupLanguage.ASCIIDOC;
                    fileSuffix = ".adoc";
                    break;
                case Markdown:
                default:
                    markupLanguage = MarkupLanguage.MARKDOWN;
                    fileSuffix = ".md";
            }
            Swagger2Doc.doGenerate(markupLanguage, url, fileName);
        } catch (MalformedURLException | UnknownHostException | IllegalArgumentException e) {
            log.error("无法访问的url:" + url, e);
            throw new RuntimeException("请检查输入的URL是否可访问且有内容");
        } catch (Exception e) {
            log.error("导出失败", e);
            throw new RuntimeException("导出失败" + e.getLocalizedMessage());
        }
        // 生成后导出
        String filePath = "./tmp/" + fileName + fileSuffix;
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        // 异步延后删除这个文件
        asyncJob.deleteFile(filePath);
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

}
