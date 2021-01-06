package Logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class ManipulatesDatabase {

    ManipulaRelacao produtos;
    Records produtosRecords;
    
    public ManipulatesDatabase(String file) throws IOException {
        File directory = new File(file);
        if (!directory.exists() && !directory.isDirectory()) {
            directory.mkdir();
        }
        File files = new File(file+"/_produtoRecords.txt");
        if(createFile(files)||files.length()==0){
            RelacaoProduto o=new RelacaoProduto(files);
        }
        produtosRecords=new Records(files);
        files = new File(file + "/_Produto.txt");
        createFile(files);
        produtos=new ManipulaRelacao(file+"/_Produto.txt", produtosRecords);
    }
    private boolean createFile(File file) throws IOException{
        if (!file.exists()) {
            file.createNewFile();
            return true;
        }
        return false;
    }

    public boolean InserirProduto(Object[] o) throws Exception{
            return produtos.insert(o);
    }
    public void deleteProduto(Object []o) throws Exception {
        produtos.delete(o[produtosRecords.getNome("Id")]);
    }

   public Object[] searchByProdutoID(int Id) throws Exception {
        return produtos.searchObject(Id, 0);
   }
   
    public ArrayList<Object[]> searchByDescriptionProdutos(Object value,String atributo) throws Exception {
        return produtos.searchDescription(value, produtosRecords.getNome(atributo));
    }
    public boolean updateRecordsProduto(Object[] o) throws Exception {
      return   produtos.update(o); 
    }
    
}

