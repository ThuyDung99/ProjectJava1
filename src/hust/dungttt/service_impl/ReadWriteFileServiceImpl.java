package hust.dungttt.service_impl;

import hust.dungttt.service.ReadWriteFileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileServiceImpl implements ReadWriteFileService {
    @Override
    public void writeFileText(String fileName, List<String> stringList) throws IOException {
        //        FileWriter fw = new FileWriter(fileName, true);
        FileWriter fw = new FileWriter(fileName); //khai báo file
        BufferedWriter bw = new BufferedWriter(fw); //khai báo bộ nhớ đọc ghi
        for (String s: stringList) {
            bw.write(s);
            bw.write("\n"); // ngăn cách các trường bằng ###
        }
        bw.flush();
        bw.close();
    }

    @Override
    public List<String> readFileText(String fileName) throws IOException {
        List<String> stringList = new ArrayList<>();
        FileReader frr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(frr);
        String text;
        while ((text = br.readLine()) != null) {
            stringList.add(text);
        }
        return stringList;
    }
}
