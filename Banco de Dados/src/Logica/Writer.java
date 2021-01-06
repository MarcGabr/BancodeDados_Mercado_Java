package Logica;

import java.io.RandomAccessFile;

public class Writer {
        RandomAccessFile file;
        Records records;

    public Writer(RandomAccessFile file, Records records) {
        this.file = file;
        this.records = records;
    }
    private boolean write(Object o) throws Exception {
        switch (o.getClass().getSimpleName()) {
            case "Integer":
                file.writeInt((int) o);
                return true;
            case "String":
                file.writeBytes((String) o);
                return true;
            case "Double":
                file.writeDouble((double) o);
                return true;
            case "Float":
                file.writeFloat((Float) o);
                return true;
            case "Character":
                file.writeChar((char) o);
                return true;
            case "Long":
                file.writeLong((long) o);
                return true;
            case "Boolean":
                file.writeBoolean((boolean) o);
                return true;
            case "Short":
                file.writeShort((short) o);
                return true;
            case "Byte": 
                file.writeByte((byte)o);
                return true;
                
        }
        return false;
    }
    public boolean writerRegistre(Object[] o, int position) throws Exception {
        try{
            writerRecords(o, records.getSize()*position);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean writerObject(Object o, int position,int column) throws Exception {
        try {
            file.seek((records.getSize()*position)+records.getPositionInLine(column));
            if (o.getClass() == String.class)
                o = setStringSize((String) o, records.getBytes(column));
            write(o);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean writerRegistre(Object[] o)  throws Exception {
        try {
            writerRecords(o, file.length());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void writerRecords(Object[] o, long length) throws Exception {
        file.seek(length);
        int i=0;
            for (Object l:o) {
                if (l.getClass() == String.class)
                    l = setStringSize((String) l, records.getBytes(i));
                i++;
                write(l);
            }
    }
    public String setStringSize(String o, int size) {
    	o=o.replaceAll(" ", "");
        if (o.length() <= size)
            for (; o.length() < size;) 
                o=o.concat(" ");
                
        return o.substring(0, size);
    }
}