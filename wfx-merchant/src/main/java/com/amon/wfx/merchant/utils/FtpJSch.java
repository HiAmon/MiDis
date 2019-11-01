package com.amon.wfx.merchant.utils;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.UUID;
import java.util.Vector;

public class FtpJSch {

    private static ChannelSftp sftp = null;

    //账号
    private static String user = "root";
    //主机ip
    private static String host =  "47.97.41.73";
    //密码
    private static String password = "19990114";
    //端口
    private static int port = 22;
    //上传到服务器上的地址
    private static String directory = "/home/amon/images";
    //下载到本地的目录
    private static String saveFile = "D:\\Micro_Distribution\\ftpDir\\images\\";

    public static FtpJSch getConnect() throws Exception{
        FtpJSch ftp = new FtpJSch();

        JSch jsch = new JSch();

        //获取sshSession  账号-ip-端口
        Session sshSession =jsch.getSession(user, host, port);
        //添加密码
        sshSession.setPassword(password);
        Properties sshConfig = new Properties();
        //严格主机密钥检查
        sshConfig.put("StrictHostKeyChecking", "no");

        sshSession.setConfig(sshConfig);
        //开启sshSession链接
        sshSession.connect();
        //获取sftp通道
        Channel channel = sshSession.openChannel("sftp");
        //开启
        channel.connect();
        sftp = (ChannelSftp) channel;

        return ftp;
    }


    public String upload(File file,String filename) {

//        String fileName = null;
        try {
            sftp.cd(directory);
          //file = new File(uploadFile);
            //获取随机文件名
//            fileName  = UUID.randomUUID().toString() + file.getName().substring(file.getName().length()-5);
//            fileName = file.getName();
            //(Math.random()*1000000+1000000+"").substring(6) +
            //文件名是随机数加文件名的后5位
            sftp.put(new FileInputStream(file), filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file == null ? null : filename;
    }


    public void download(String downloadFileName) {
        try {
            sftp.cd(directory);

            File file = new File(saveFile);

            sftp.get(downloadFileName, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String deleteFile) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Vector listFiles(String directory)
            throws SftpException {
        return sftp.ls(directory);
    }



}
