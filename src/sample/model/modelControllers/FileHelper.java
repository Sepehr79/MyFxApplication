package sample.model.modelControllers;

import java.io.*;
import java.util.Arrays;
/**
 *
 * @author sepehr
 */
public class FileHelper {
    private FileHelper(){

    }
    public static void writeList(List list){
        try(FileOutputStream fout = new FileOutputStream("list.txt"); ObjectOutputStream oout = new ObjectOutputStream(fout)) {
            oout.writeObject(list);
        }
        catch(Exception ex){
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }
    public static List readList()throws IOException, ClassNotFoundException{
        try(FileInputStream fin = new FileInputStream("list.txt"); ObjectInputStream oin = new ObjectInputStream(fin)) {
            List list = (List)oin.readObject();
            return list;
        }
        catch(FileNotFoundException ex){
            return new List();
        }

    }
}