package com.zenchn.mlibrary.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 作    者：wangr on 2017/4/24 11:09
 * 描    述：ZIP压缩工具类
 * 修订记录：
 */
public class GZIPUtils {

    private GZIPUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * GZIP解压
     *
     * @param in 要解压的压缩文件的输入流
     * @param os 解压后的文件的输入流
     * @throws IOException
     */
    public static void unZip(InputStream in, OutputStream os) throws IOException {
        InputStream is = new GZIPInputStream(in);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }


    /**
     * GZIP压缩
     *
     * @param in 要压缩的文件输入流
     * @param os 压缩后的文件的输出流
     * @throws Exception
     */
    public static void zip(InputStream in, OutputStream os) throws Exception {
        OutputStream out = new GZIPOutputStream(os);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.flush();
        out.close();
        in.close();
    }
}
