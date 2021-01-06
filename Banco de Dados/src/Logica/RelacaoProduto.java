package Logica;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class RelacaoProduto {

    public RelacaoProduto(File file) throws IOException {
        String o=
           "Id,Integer,4;"
                + "Nome,String,100;"
                + "Valor, Float, 4;"
                + "Ramo,String,100;"; 
        PrintWriter l=new PrintWriter(file);
        
        l.write(o);
        l.close();
    }
}
