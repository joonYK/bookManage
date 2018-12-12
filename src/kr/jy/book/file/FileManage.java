package kr.jy.book.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManage {
    List<String> dataList = null;
    private File file = null;
    private BufferedReader br = null;
    private BufferedWriter bw = null;

    public FileManage(String filename) {
        file = new File(filename);
    }

    public void connectFile() throws IOException {
        if(!file.exists()) {
            file.createNewFile();
        }

        try {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List readFile() throws IOException {
        dataList = new ArrayList<String>();
        String data = "";
        try {
            while ((data = br.readLine()) != null) {
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        return dataList;
    }

    public void writeFile() {
        
    }

}
