package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Records {

    private final int[] bytes;
    private final String[] types;
    private final long[] positionInLine;
    private long size = 0;
    private String[] nome;

    public Records(File file) throws IOException {
        BufferedReader files=new BufferedReader(new FileReader(file));
        String[] o = files.readLine().replaceAll(" ", "").split(";");
        files.close();
        types = new String[o.length];
        bytes = new int[o.length];
        positionInLine = new long[o.length];
        nome=new String[o.length];
        int k = 0;
        for (String p : o) {
            String[] l = p.split(",");
            nome[k] = l[0];
            types[k] = l[1];
            bytes[k] = Integer.valueOf(l[2]);
            System.out.println(nome[k]+" "+bytes[k]);
            positionInLine[k] = size;
            size += bytes[k++];
        }
    }

    public String getNome(int index) {
        return nome[index];
    }

    public int getNumberOfRecords() {
        return bytes.length;
    }

    public long getSize() {
        return size;
    }

    public int getBytes(int index) {
        return bytes[index];
    }

    public String getTypes(int index) {
        return types[index];
    }

    public long getPositionInLine(int index) {
        return positionInLine[index];
    }

    int getNome(String atributo) {
        int i = 0;
        for (String o : nome) {
            if (o.equals(atributo)) {
                return i;
            }
            i++;
        }
        return -1;

    }
}

