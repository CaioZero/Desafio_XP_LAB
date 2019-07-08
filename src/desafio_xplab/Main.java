package desafio_xplab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Caio Augusto
 */
public class Main {
    public static void main(String[] args) {  
     
        /*File file = new File ("Novo Diretório");
        file.mkdir();Criar novo diretorio
        file.delete();Deletar este diretorio*/
        
        File arquivo = new File ("Dados.txt");
        
        try {
            
              String linha,linha1,linha3,linha4,linha5;
              int j=0,k=0,aux=0,aux1=0;
              
              /*Arquivo dos Dados*/
              FileWriter fileWriterDados = new FileWriter(arquivo);
              BufferedWriter escreverDados = new BufferedWriter(fileWriterDados);
              List<String> dadosList = new ArrayList();
              
              /*Arquivo Clientes*/              /*Neste diretorio, colocar o caminho do arquivo clientes.txt*/
              FileReader lerClientes = new FileReader("C:\\Users\\Caio Augusto\\Desktop\\clientes.txt");
              BufferedReader lerBufferClientes = new BufferedReader(lerClientes);
              List<String> clienteList = new ArrayList();
              
               /*Arquivo Bonus*/            /*Neste diretorio, colocar o caminho do arquivo bonus.txt*/
              FileReader lerBonus = new FileReader("C:\\Users\\Caio Augusto\\Desktop\\bonus.txt");
              BufferedReader lerBufferBonus = new BufferedReader(lerBonus);
              List<String> bonusList = new ArrayList();

              
              linha =lerBufferBonus.readLine();
              linha1=lerBufferClientes.readLine();
          
              escreverDados.write(linha.replaceAll(";","|").concat(linha1));
              escreverDados.write("\n");
              
             /*Adicionando a uma lista, os dados da tabela Bonus*/             
              while((linha=lerBufferBonus.readLine())!=null){
                bonusList.add(linha);
             }
        
               /*Adicionando ao arquivo Dados, os dados de Cliente*/
              while((linha = lerBufferClientes.readLine())!=null){
                  clienteList.add(linha);
              }
               
              while(j<clienteList.size()){
                   linha=bonusList.get(j).substring(0,2).replaceAll(";","");                       
               int x=0;              
               while(k<=bonusList.size()+1){
               linha1=clienteList.get(x).substring(0,2).replace(";","");
               if(linha.equals(linha1)){
                   
                   /*Se a linha for o cliente 10*/
                   if(clienteList.get(x).substring(1,2).equalsIgnoreCase("0")){
                    linha3=bonusList.get(k).replace(';', '|')+(clienteList.get(x).substring(2).replaceAll(";","|"));
                  
             linha4=bonusList.get(k).replace(';', '|').concat(clienteList.get(x).substring(9).replaceAll(";","|"));               
                    aux = Integer.parseInt(linha3.substring(3,7));
                     
                       if(linha4.charAt(13) == ' '){
                           aux1=Integer.parseInt(linha4.substring(9,13));
                       }else{
                           aux1 = Integer.parseInt(linha4.substring(9,12));
                       }
                     aux=aux+aux1;
                    
                      linha5=Integer.toString(aux);
                       linha5="|"+linha5+"|";
                       dadosList.add(linha3.concat(linha5));
                      
                   }                   
                   else{
                     linha3=bonusList.get(k).replace(';', '|')+"|"+(clienteList.get(x).substring(2).replaceAll(";","|"));
                  
                    
                     linha4=bonusList.get(k).replace(';', '|').concat(clienteList.get(x).substring(8).replaceAll(";","|"));               
                      aux = Integer.parseInt(linha3.substring(2,6));
                     
                       if(linha4.charAt(13) == ' '){
                           aux1=Integer.parseInt(linha4.substring(8,13));
                       }else{
                           aux1 = Integer.parseInt(linha4.substring(8,12));
                       }
                     aux=aux+aux1;
                      linha5=Integer.toString(aux);
                      linha5="|"+linha5+"|";
                     dadosList.add(linha3.concat(linha5));
                   }
                  k++;
                  break;
                  }//fimif
                x++;           
               }//fimwhile
               j++;
            }//endwhile
                
             
            /*Escrevendo um novo arquivo com os dados de dadosList*/
              for(String s : dadosList){
                  /*escrever colunas aqui*/
                //  escreverDados.write(s);
                  escreverDados.write(s+"\n");
              } 
              
              /*Fechando o arquivo*/    
              escreverDados.close();
              fileWriterDados.close();
                               
        }
        catch (IOException e) {
           JOptionPane.showMessageDialog(null, "Ocorreu um erro:\n" + e.getMessage());
        }
      
    }               
 }
    
