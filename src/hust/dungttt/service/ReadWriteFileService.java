package hust.dungttt.service;

import java.io.IOException;
import java.util.List;

public interface ReadWriteFileService {

    void writeFileText(String fileName, List<String> stringList) throws IOException;

    public List<String> readFileText(String fileName) throws IOException;
}
