package src.main.com.slimani_ce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Write {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(configuration);
        Path path = new Path("/BDDC/CPP/Cours/CoursCPP1");
        FSDataOutputStream fsdos = fs.create(path);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fsdos, StandardCharsets.UTF_8));
        br.write("BDDC 2");
        br.newLine();
        br.write("BDDC 2");
        br.close();
        fs.close();
    }
}
