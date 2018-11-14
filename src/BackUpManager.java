import java.io.*;
import java.util.ArrayList;

public class BackUpManager {
    private String backup;
    //private Agenda a=new Agenda();

    public void createBackup(String contactsFormated) {
        File file = new File("backup.cvs");
        File dir = new File("backups");
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer(file.getPath(),contactsFormated);


    }

//    private ArrayList<String> readFile(String path) {
//        ArrayList<String> lineArray=new ArrayList<>();
//        String line;
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//
//            while ((line=reader.readLine())!=null) {
//                lineArray.add(line);
//            }
//        } catch (
//                FileNotFoundException exception)
//
//        {
//            System.out.println("cant find file contacts");
//        } catch (IOException io)
//
//        {
//            System.out.println("IOException");
//        }
//        return lineArray;
//    }
    private void writer(String path,String contactsFormated){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            writer.write(contactsFormated);

        } catch (FileNotFoundException f) {
            System.out.println("Cant find file  ");
        } catch (IOException io) {
            System.out.println("Cant find file IOEXEPTION");
        }
    }
}
