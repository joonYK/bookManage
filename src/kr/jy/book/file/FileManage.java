package kr.jy.book.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManage {
    List<String> dataList;
    private File file;
    private BufferedReader br;
    private BufferedWriter bw;

    public FileManage(String filename) {
        file = new File(FileManage.class.getResource("").getPath() + "../resources/" + filename);
    }

    /**
     * 파일 내용 읽기
     * @return
     */
    public List readFile() {
        dataList = new ArrayList<String>();
        String data = "";

        try {
            br = new BufferedReader(new FileReader(file));

            while ((data = br.readLine()) != null) {
                dataList.add(data);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList();
        }

        return dataList;
    }

    /**
     * 파일 쓰기
     * @param data
     * @return
     */
    public boolean writeFile(Object[] data) {
        try {
            bw = new BufferedWriter(new FileWriter(file));

            for(Object o : data) {
                bw.write(o.toString());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


}
