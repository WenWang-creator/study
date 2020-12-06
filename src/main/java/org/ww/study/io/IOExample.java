package org.ww.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 练习IO
 * @author meow
 */
public class IOExample {
    public static void main(String[] args) {
        example3();
    }



    /**
     * 在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建
     *
     * 一个目录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文件
     */
    public static void example1() {
        File file = new File("D://HelloWorld.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建文件出现异常,异常原因是：" + e.getMessage());
        }

        if (file.isDirectory()) {
            System.out.println("file是目录");
        } else if (file.isFile()){
            System.out.println("file是文件");
        } else {
            System.out.println("file不知道是啥玩意儿");
        }

        File dir = new File("D://IOTest");
        if (dir.mkdir()) {
            System.out.println("目录创建成功");
        } else {
            System.out.println("目录创建失败");
        }
        File file1 = new File("D://IOTest//HelloWorld.txt");
        if (file.renameTo(file1)) {
            System.out.println("文件移动成功");
        } else {
            System.out.println("文件移动失败");
        }

        File[] list = dir.listFiles();
        if (list == null || list.length == 0) {
            System.out.println("目录内容为空");
        } else {
            for (File s : list) {
                System.out.println(s);
            }
        }

    }

    /**
     * 递归实现输入任意目录，列出文件以及文件夹
     *
     * 递归条件：如果是一个目录则遍历下面的文件，如果是文件则打印路径
     *
     */
    public static void example2(){
        //需要递归的目录
        String dirPath = "E:/wallpapercache";
        File file = new File(dirPath);

        example2Util(file);
    }

    private static void example2Util(File file) {
        if (file.isFile()) {
            System.out.println(file.getPath());
        } else {
            File[] files = file.listFiles();
            if (files != null && files.length != 0) {
                for (File f:files) {
                    example2Util(f);
                }
            } else {
                System.out.println(file.getPath());
            }
        }
    }

    /**
     * 从磁盘读取一个文件到内存中，再打印到控制台
     */
    private static void example3() {
        File file = new File("D:\\IOTest\\HelloWorld.txt");
        StringBuffer str = new StringBuffer();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                str.append(new String(buf,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("从输入流中读取数据出现异常，异常原因：" + e.getMessage());
        }
        System.out.println(str);
    }




}
