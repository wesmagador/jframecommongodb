package banco.de.dados.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.bson.Document;
import org.omg.CORBA.portable.UnknownException;

/**
 * @author wesle
 */

public class Corpo extends JFrame implements ActionListener{

    /**
  * Declaração das variáveis.
  * 
  * @param JLabel   Declaração de um texto.
  * @param JTextField    Declaração de um campo de texto.
  * @param JFormattedTextField Declaração de um campo de texto formatado.
  * @param JButton  Declaração de botão interagivel.
  * @param JComboBox Declaração de caixa de seleção.
  */
    
    JLabel lblID;
    JFormattedTextField txtID;
    JLabel lblNome;
    JTextField txtNome;
    JLabel lblCpf;
    JFormattedTextField ftxtCpf;
    JButton btnEnviar;
    JLabel cmbNome;
    JComboBox cmbCombo;
    JLabel dtaNome;
    JFormattedTextField ftxtData;
    JLabel slaNome;
    JFormattedTextField ftxtSalario;
    JLabel lblidade;
    JFormattedTextField ftxtidade;
    JLabel lblemail;
    JTextField txtemail;
    JLabel lblsexo;
    JComboBox cmbsexo;
    
    /**
     * Declaração dos objetos
     * 
     * @param MaskFormatter Atribuir um formato ao campo de texto.
     * @param addActionListener Adicionar um comando ao botão.
     * @param Object adicionar objetos a lista do combobox.
     * @param setToolTipText adicionar uma mensagem ao passar o mouse por cima.
     * @throws ParseException
     */
    protected Corpo() throws ParseException{
        
     lblID = new JLabel("ID");
     txtID = new JFormattedTextField(new MaskFormatter("#####")); 
     lblNome = new JLabel("Nome");
     txtNome = new JTextField();
     lblCpf = new JLabel("CPF");
     ftxtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
     
     btnEnviar = new JButton("Enviar");
     btnEnviar.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) { {
             try {
                 btnEnviar.setToolTipText("Enviar dados");
                 Funcionario();
             } catch (UnknownException ex) {
                 Logger.getLogger(Corpo.class.getName()).log(Level.SEVERE, null, ex);
             }
             } 
         }
     });
     
     cmbNome = new JLabel("Tipo de usuário");
     cmbCombo = new JComboBox(new Object[]{"Diretor", "Gestor", "Técnico"});
     cmbCombo.setToolTipText("Expandir");
     dtaNome = new JLabel("Data de Nascimento");
     ftxtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
     slaNome = new JLabel("Salário");
     ftxtSalario = new JFormattedTextField(new MaskFormatter("R$#.###,##"));
     ftxtidade = new JFormattedTextField(new MaskFormatter("##"));
     lblidade = new JLabel("Idade");
     lblemail = new JLabel("Email");
     txtemail = new JTextField();
     lblsexo = new JLabel("Sexo");
     cmbsexo = new JComboBox(new Object[]{"Masculino", "Feminino"});
     cmbsexo.setToolTipText("Expandir");
     
     /**
     * Configuração do Frame
     * 
     * @param setSize Escolher o tamando do JFrame.
     * @param setTitle Escolher título do JFrame.
     * @param setLayout nao atribuir nenhum gerenciador.
     */
     setSize(390, 600);
     setTitle("Cadastro de Colaboradores Supermarket");
     setLayout(null);
     
     /**
     * Posições dos atributos
     * 
     * @param X posição horizontal
     * @param Y posição vertical
     * @param LARGURA tamanho em largura
     * @param ALTURA tamanho em altura
     */
     lblID.setBounds(0, 0, 100, 25);
     txtID.setBounds(150, 0, 50, 25);
     lblNome.setBounds(0, 50, 100, 25);
     txtNome.setBounds(150, 50, 200, 25);
     lblCpf.setBounds(0, 62, 100, 100);
     ftxtCpf.setBounds(150, 100, 100, 25);
     cmbNome.setBounds(0, 150, 200, 25);
     cmbCombo.setBounds(150, 150, 80, 25);
     dtaNome.setBounds(0, 200, 200, 25);
     ftxtData.setBounds(150, 200, 80, 25);
     slaNome.setBounds(0, 250, 200, 25);
     ftxtSalario.setBounds(150, 250, 80, 25);
     lblidade.setBounds(0, 300, 100, 25);
     ftxtidade.setBounds(150, 300, 25, 25);
     lblemail.setBounds(0, 350, 200, 25);
     txtemail.setBounds(150, 350, 200, 25);
     lblsexo.setBounds(0, 400, 200, 25);
     cmbsexo.setBounds(150, 400, 120, 25);
     btnEnviar.setBounds(130, 450, 120, 100);
     
     /**
     * Adicionando itens ao painel.
     * 
     * @param getContentPane função para adicionar ao JFrame.
     */
     getContentPane().add(lblID);
     getContentPane().add(txtID);
     getContentPane().add(lblNome);
     getContentPane().add(txtNome);
     getContentPane().add(lblCpf);
     getContentPane().add(ftxtCpf);
     getContentPane().add(btnEnviar);
     getContentPane().add(cmbNome);
     getContentPane().add (cmbCombo);
     getContentPane().add(dtaNome);
     getContentPane().add (ftxtData);
     getContentPane().add(slaNome);
     getContentPane().add (ftxtSalario);
     getContentPane().add(lblidade);
     getContentPane().add (ftxtidade);
     getContentPane().add(lblemail);
     getContentPane().add(txtemail);
     getContentPane().add(lblsexo);
     getContentPane().add (cmbsexo);
     
    }     

    /**
     * Classe de para pegar texto e mostrar no console.
     * 
     * @param MongoClient criar um cliente ao servidor MongoDB.
     * @param MongoDatabase conectar ao banco de dados específicado.
     * @param MongoCollection conectar ao collection específicado.
     * @param showMessageDialog mostrar uma mensagem de diálogo ao concluir.
     * @throws UnknownException
     */
    protected void Funcionario() throws UnknownException {
        
        String ID=txtID.getText();
        System.out.println(ID);
        
        String nome=txtNome.getText();
        System.out.println(nome);
        
        String cpf=ftxtCpf.getText();
        System.out.println(cpf);
        
        String combo=cmbCombo.getSelectedItem().toString();
        System.out.println(combo);
        
        String data=ftxtData.getText();
        
        String salario=ftxtSalario.getText();
        System.out.println(salario);
        
        String idade=ftxtidade.getText();
        System.out.println(idade);
        
        String email=txtemail.getText();
        System.out.println(email);
        
        String sexo=cmbsexo.getSelectedItem().toString();
        System.out.println(sexo);
        
        
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection < Document > collection = database.getCollection("users");
        
        Document d1 = new Document("_id", ID);
        d1.append("_Nome", nome);
        d1.append("_CPF", cpf);
        d1.append("_Tipo", combo);
        d1.append("_Data", data);
        d1.append("_Salario", salario);
        d1.append("_Idade", idade);
        d1.append("_Email", email);
        d1.append("_Sexo", sexo);
        
        collection.insertOne(d1);
        
        JOptionPane.showMessageDialog(null, "Usuário " +nome+ " inserido com sucesso");
        
    }
    
    /**
     * Override do JButton ao clicar.
     * 
     * @param ae função do evento do JButton.
     * @throws UnsupportedOperationException caso haja alguma exceção.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Não é permitido");
    }

}
