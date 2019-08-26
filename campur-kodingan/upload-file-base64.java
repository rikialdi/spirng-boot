package com.management_user.api.test;

import com.management_user.api.dto.UserDetailDto;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {public static void main(String args[]) throws IOException {
//    String s1="hello string";
//    String s1upper=s1.toUpperCase(); //gede
//    System.out.println(s1upper);

//    createfolder();
//    byte_file_base_64();
    getFile_base64();
}
public  static  void createfolder(){
    File newFolder = new File("/home/tog/toggit/baru");

    boolean created =  newFolder.mkdir();

    if(created)
        System.out.println("Folder was created !");
    else
        System.out.println("Unable to create folder");

}
//    private static  convert base 64 to file
public static void byte_file_base_64() throws IOException {
    String UPLOADED_FOLDER = "/home/tog/toggit/";
    String base64 = "c2F5YSBkZWtzcmlwc2k=";

    byte[] bytes = Base64.decodeBase64(base64.getBytes());

    Path path = Paths.get(UPLOADED_FOLDER + "baruya.txt");
    Files.write(path, bytes);
}
   // ambil file ke komputer , file convert to base64, convert lagi ke file
   
    public static void getFile_base64(){
        File f = new File("/home/tog/pgadmin.log");
        FileInputStream fin = null;
        FileChannel ch = null;
        try {
            String UPLOADED_FOLDER = "/home/tog/toggit/";
            fin = new FileInputStream(f);
            ch = fin.getChannel();
            int size = (int) ch.size();
            MappedByteBuffer buf = ch.map(FileChannel.MapMode.READ_ONLY, 0, size);
            byte[] bytes = new byte[size]; //file asli
            buf.get(bytes);
            System.out.println(size + " :================== " + bytes);

            byte[] bytess_encode = Base64.encodeBase64(bytes);//file encode to base64

            byte[] bytess_decode = Base64.decodeBase64(bytess_encode);//file encode to base64



 
            Path path = Paths.get(UPLOADED_FOLDER + "baruya2.log");
            Files.write(path, bytess_decode);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (ch != null) {
                    ch.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

 
}
