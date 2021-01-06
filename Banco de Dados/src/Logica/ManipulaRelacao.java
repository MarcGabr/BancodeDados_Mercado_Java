package Logica;

import java.io.*;
import java.util.ArrayList;

public class ManipulaRelacao {
    String files;
    RandomAccessFile file;
    final long sizeRecords;
    Reader reader;
    Writer writer;
    Records records;
    int lenght;

    public ManipulaRelacao(String files, Records records) throws FileNotFoundException, IOException {
        this.files=files;
        this.file = new RandomAccessFile(files, "rw");
        this.records = records;
        this.sizeRecords = records.getSize();
        this.lenght=(int) file.length();
        reader = new Reader(file, records);
        writer = new Writer(file, records);
    }

    public boolean insert(Object[] o) throws Exception {
        if (search(o[0], 0) == -1) {
            writer.writerRegistre(o);
            salvar();
            return true;
        }
        salvar();
        return false;
    }
    
    public int search(Object o, int colmn) {
        try {
            for (int i = 0; i < file.length()/sizeRecords; i++){
                if (o.equals(reader.readerObject(i, colmn))){
                    return i;
                }
                    
            }
        } catch (Exception ex) {}
        return -1;
    }

    public Object[] searchObject(Object o, int colmn) throws Exception {
        int i = search(o, colmn);
        if (i != -1)
            return reader.readerRegistre(i);
        salvar();
        return null;
    }

    public ArrayList<Object[]> searchDescription(Object o, int column) throws Exception {
        ArrayList<Object[]> p = new ArrayList<>();
        if (o.getClass() == String.class){
            o=setStringSize((String) o);
        }
        for (int i = 0; i < file.length()/sizeRecords; i++)
            if (o.equals(reader.readerObject(i, column))){
                p.add(reader.readerRegistre(i));
            }
        salvar();
        return p;
    }
    public boolean delete(Object o) throws Exception {
        int i = search(o, 0);
        if (i != -1)
            writer.writerRegistre(reader.readerRegistre((int) ((file.length() - sizeRecords) / sizeRecords)), i);
        else
            return false;
        
        file.setLength(file.length() - sizeRecords);
        salvar();
        return true;
    }
    public boolean update(Object o[]) throws Exception {
        int i = 0;
            for (Object p : o) {
                if (p.getClass() == String.class)
                    o[i] = setStringSize((String) p);
                i++;
            }        
        i = search(o[0],0);
        if (i != -1) {
            writer.writerRegistre(o, i);
            salvar();
            return true;
        }salvar();
        return false;
    }

    public void salvar() throws IOException{
        file.close();
        file=new RandomAccessFile(files, "rw");
        reader = new Reader(file, records);
        writer = new Writer(file, records);
    }
    public String setStringSize(String o) {
           
        return o.replaceAll(" ", "");
    }
}
