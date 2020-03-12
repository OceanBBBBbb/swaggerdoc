package com.ocean.swaggerdoc.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * EnableAsync job
 *
 * @author oceanBin on 2020/3/12
 */
@Slf4j
@Service
public class AsyncJob {

    @Async
    public void deleteFile(final String filePath){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean delete = new File(filePath).delete();
        log.info("删除"+filePath+"结果="+delete);
    }
}
