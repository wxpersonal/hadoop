package hdfs;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author weix
 * @date 2018/12/18 13:29
 */
public class HDFSTest1 {


    static {
        //为了让URL能够识别hdfs地址
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) {
        InputStream in = null;

        try {
            in = new URL("hdfs://172.16.54.150:9000/test/input/1901").openStream ();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
