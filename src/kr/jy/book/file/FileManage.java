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
     * 파일 연결 (writer, reader 생성)
     * @throws IOException
     */
    public void connectFile() throws IOException {
        if(!file.exists()) {
            file.createNewFile();
        }

        br = new BufferedReader(new FileReader(file));
        bw = new BufferedWriter(new FileWriter(file, true));
    }

    /**
     * 파일 내용 읽기
     * @return
     */
    public List readFile() {
        dataList = new ArrayList<String>();
        String data = "";
        try {
            while ((data = br.readLine()) != null) {
                dataList.add(data);
            }
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
    public boolean writeFile(String data) {
        try {
            bw.newLine();
            bw.write(data);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 파일 닫기
     * @throws IOException
     */
    public void closeFile() throws IOException {
        if(file == null) {
            return;
        }

        br.close();
        bw.close();
    }

    public static void main(String[] args) {
        FileManage fileManage = new FileManage(FileManage.class.getResource("").getPath() + "../resources/member.txt");
        List<String> list = null;
        try {
            fileManage.connectFile();
            fileManage.writeFile("김김김, 울산시, 01023141534");

            list = fileManage.readFile();
            for(String d : list) {
                System.out.println(d);
            }

            fileManage.closeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
