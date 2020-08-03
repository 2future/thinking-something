package com.mz.compress;

import org.apache.commons.io.FileUtils;
import org.xerial.snappy.Snappy;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author mz
 * @version V1.0
 * @Title CompressDemo
 * @Package com.mz.compress
 * @Description
 * @date 2020/8/3 4:19 下午
 */
public class CompressDemo {

    /**
     * 原始文件
     */
    private File originalFIle;

    /**
     * 压缩后文件
     */
    private byte[] compressFIle;

    /**
     * 解压后文件
     */
    private byte[] unCompressFIle;


    public CompressDemo(File originalFIle) {
        this.originalFIle = originalFIle;
    }

    /**
     * 压缩文件
     *
     * @return
     */
    public void compressFIle() throws IOException {
        Objects.requireNonNull(this.originalFIle, "originalFIle can not be null");
        byte[] compress = Snappy.compress(FileUtils.readFileToByteArray(this.originalFIle));
        this.compressFIle = compress;
    }


    /**
     * 解压文件
     *
     * @return
     */
    public void unCompressFIle() throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(this.originalFIle);
        byte[] uncompress = Snappy.uncompress(bytes);
        this.unCompressFIle = uncompress;
    }


    public byte[] getCompressFIleByte(){
        return compressFIle;
    }

}