package Logica;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Reader {

    RandomAccessFile file;
    Records records;

    public Reader(RandomAccessFile file, Records records) {
        this.file = file;
        this.records = records;
    }

    public Object read(int bytes, String simpleClassName) throws Exception {
        
        switch (simpleClassName) {
            case "Integer": return file.readInt();
            case "String":
                byte k[] = new byte[bytes];
                if (file.read(k) == -1) 
                    throw new Exception("Wrong number of bytes");
                
                return new String(k).replaceAll(" ","");
            case "Double":return file.readDouble();
            case "Character":return file.readChar();
            case "Float":
                return file.readFloat();
            case "Long":return file.readLong();
            case "Boolean":return file.readBoolean();
            case "Short":return file.readShort();
            case "Byte": return file.readByte();
        }
        return null;
    }

    public Object[] readerRegistre(int rows) throws Exception {
        
        file.seek(records.getSize() * rows);
        Object[] o = new Object[records.getNumberOfRecords()];
        for (int i = 0; i < records.getNumberOfRecords(); i++){
            o[i] = read(records.getBytes(i), records.getTypes(i));
        }
        file.seek(0);
        return o;
    }

    public Object readerObject(int rows, int column) throws Exception {
        try {
        	
            file.seek((records.getSize() * rows) + records.getPositionInLine(column));
            Object o=read(records.getBytes(column), records.getTypes(column));
            if(o.getClass()==String.class) {
            	o=o.toString().replaceAll(" ", "");
            }
            return o;
        } catch (EOFException e) {
            return null;
        }
    }
}
