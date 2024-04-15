package src.main.com.slimani_ce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Read {
    public static void main(String[] args) throws IOException {
        Configuration cf = new Configuration();
        cf.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fileSystem = FileSystem.get(cf);
        Path path = new Path("/BDDC/CPP/Cours/CoursCPP1");
        FSDataInputStream fsdis = fileSystem.open(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fsdis, StandardCharsets.UTF_8));
        String ligne = null;
        while ((ligne=reader.readLine()) != null){
            System.out.println(ligne);
        }
        fsdis.close();
        fileSystem.close();
    }
}
