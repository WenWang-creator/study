package org.ww.study.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 发送消息客户端
 * @author 汪文
 */
public class SendClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //建立连接
            socket = new Socket("127.0.0.1", 9999);
            //发送消息
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("水晶工坊".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
