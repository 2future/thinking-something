package com.mz.compress;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author mz
 * @version V1.0
 * @Title CompressTest
 * @Package com.mz.compress
 * @Description
 * @date 2020/8/3 4:28 下午
 */
public class CompressTest {

    @Test
    void testCompressSiz() throws IOException {
        File file = new File("/Users/chaojitiangou/Documents/学习/Xxljob学习记录.docx");
        System.err.println(String.format("压缩前文件大小:%s",FileUtils.readFileToByteArray(file).length));
        CompressDemo demo=new CompressDemo(file);
        demo.compressFIle();
        byte[] compressFIleByte = demo.getCompressFIleByte();
        System.err.println(String.format("压缩后文件大小:%s",compressFIleByte.length));
    }

}