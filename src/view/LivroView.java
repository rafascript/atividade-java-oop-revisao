package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Livro;

public class LivroView extends JFrame{
	private JTable tabela;
	private JScrollPane painel;
	private JPanel painelSalvar = new JPanel();
	private JPanel painelAlterarDeletar = new JPanel();
	//Painel salvar
	private JLabel textoAno = new JLabel("Ano:");
	private JTextField campoAno = new JTextField(15);
	private JLabel textoEdicao = new JLabel("Edição:");
	private JTextField campoEdicao = new JTextField(15);
	private JLabel textoTitulo = new JLabel("Título:");
	private JTextField campoTitulo = new JTextField(15);
	private JLabel textoLocal = new JLabel("Local:");
	private JTextField campoLocal = new JTextField(15);
	private JLabel textoEditora = new JLabel("Editora:");
	private JTextField campoEditora = new JTextField(15);
	private JButton botaoSalvar = new JButton("Salvar");
	//Painel AlterarDeletar
	private JLabel textoIdAlterar = new JLabel("Id");
	private JTextField campoIdAlterar = new JTextField(15);
	private JLabel textoAnoAlterar = new JLabel("Ano:");
	private JTextField campoAnoAlterar = new JTextField(15);
	private JLabel textoEdicaoAlterar = new JLabel("Edição:");
	private JTextField campoEdicaoAlterar = new JTextField(15);
	private JLabel textoTituloAlterar = new JLabel("Título:");
	private JTextField campoTituloAlterar = new JTextField(15);
	private JLabel textoLocalAlterar = new JLabel("Local:");
	private JTextField campoLocalAlterar = new JTextField(15);
	private JLabel textoEditoraAlterar = new JLabel("Editora:");
	private JTextField campoEditoraAlterar = new JTextField(15);
	private JButton botaoAlterar = new JButton("Alterar");
	private JButton botaoDeletar = new JButton("Deletar");
	
	public LivroView() {
		this.setSize(540,300);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void configurarComponentes(ActionListener ouvinte) {
		painelSalvar.add(textoAno);
		painelSalvar.add(campoAno);
		painelSalvar.add(textoEdicao);
		painelSalvar.add(campoEdicao);
		painelSalvar.add(textoTitulo);
		painelSalvar.add(campoTitulo);
		painelSalvar.add(textoLocal);
		painelSalvar.add(campoLocal);
		painelSalvar.add(textoEditora);
		painelSalvar.add(campoEditora);
		botaoSalvar.addActionListener(ouvinte);
		painelSalvar.add(botaoSalvar);
		painelSalvar.setPreferredSize(new Dimension(250,135));
		this.add(painelSalvar);
		
		painelAlterarDeletar.add(textoIdAlterar);
		painelAlterarDeletar.add(campoIdAlterar);
		painelAlterarDeletar.add(textoAnoAlterar);
		painelAlterarDeletar.add(campoAnoAlterar);
		painelAlterarDeletar.add(textoEdicaoAlterar);
		painelAlterarDeletar.add(campoEdicaoAlterar);
		painelAlterarDeletar.add(textoTituloAlterar);
		painelAlterarDeletar.add(campoTituloAlterar);
		painelAlterarDeletar.add(textoAnoAlterar);
		painelAlterarDeletar.add(campoAnoAlterar);
		painelAlterarDeletar.add(textoLocalAlterar);
		painelAlterarDeletar.add(campoLocalAlterar);
		painelAlterarDeletar.add(textoEditoraAlterar);
		painelAlterarDeletar.add(campoEditoraAlterar);
		botaoAlterar.addActionListener(ouvinte);
		botaoDeletar.addActionListener(ouvinte);
		painelAlterarDeletar.add(botaoAlterar);
		painelAlterarDeletar.add(botaoDeletar);
		painelAlterarDeletar.setPreferredSize(new Dimension(250,300));
		this.add(painelAlterarDeletar);
		
		this.limparCampos();
	}
	
	public void carregarTabela(List<Livro> listaLivros, MouseListener ouvinte2) {
		if(painel != null)
			this.remove(painel);
		String[] nomesColunas = new String[] {
				"Id","Ano", "Edição", "Título", "Local", "Editora"
		};

		Object[][] dados = new Object[listaLivros.size()][6];	
		for(int i=0; i<listaLivros.size(); i++) {
			dados[i][0] = listaLivros.get(i).getId();
			dados[i][1] = listaLivros.get(i).getAno();
			dados[i][2] = listaLivros.get(i).getEdicao();
			dados[i][3] = listaLivros.get(i).getTitulo();
			dados[i][4] = listaLivros.get(i).getLocal();
			dados[i][5] = listaLivros.get(i).getEditora();
		}
		tabela = new JTable(dados,nomesColunas);
		painel = new JScrollPane(tabela);
		painel.setPreferredSize(new Dimension(520, 115));
		this.tabela.addMouseListener(ouvinte2);
		this.add(painel);
		this.revalidate();
	}
	
	public void limparCampos() {
		this.campoIdAlterar.setText("");
		this.campoAnoAlterar.setText("");
		this.campoEdicaoAlterar.setText("");
		this.campoTituloAlterar.setText("");
		this.campoLocalAlterar.setText("");
		this.campoEditoraAlterar.setText("");
		this.campoAno.setText("");
		this.campoEdicao.setText("");
		this.campoTitulo.setText("");
		this.campoLocal.setText("");
		this.campoEditora.setText("");
		this.botaoAlterar.setEnabled(false);
		this.botaoDeletar.setEnabled(false);
	}
	
	public JTextField getCampoAno() {
		return campoAno;
	}

	
	
	public JTextField getCampoEdicao() {
		return campoEdicao;
	}

	public void setCampoEdicao(JTextField campoEdicao) {
		this.campoEdicao = campoEdicao;
	}

	public JTextField getCampoTitulo() {
		return campoTitulo;
	}

	public void setCampoTitulo(JTextField campoTitulo) {
		this.campoTitulo = campoTitulo;
	}
	
	public JTextField getCampoLocal() {
		return campoLocal;
	}

	public void setCampoLocal(JTextField campoLocal) {
		this.campoTitulo = campoLocal;
	}
	
	public JTextField getCampoEditora() {
		return campoEditora;
	}

	public void setCampoEditora(JTextField campoEditora) {
		this.campoEditora = campoEditora;
	}
	
	//=====================================================
	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public void setBotaoSalvar(JButton botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}

	public JButton getBotaoAlterar() {
		return botaoAlterar;
	}

	public void setBotaoAlterar(JButton botaoAlterar) {
		this.botaoAlterar = botaoAlterar;
	}

	public JButton getBotaoDeletar() {
		return botaoDeletar;
	}

	public void setBotaoDeletar(JButton botaoDeletar) {
		this.botaoDeletar = botaoDeletar;
	}
	//=====================================================
	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JScrollPane getPainel() {
		return painel;
	}

	public void setPainel(JScrollPane painel) {
		this.painel = painel;
	}

	public JPanel getPainelSalvar() {
		return painelSalvar;
	}

	public void setPainelSalvar(JPanel painelSalvar) {
		this.painelSalvar = painelSalvar;
	}

	public JPanel getPainelAlterarDeletar() {
		return painelAlterarDeletar;
	}

	public void setPainelAlterarDeletar(JPanel painelAlterarDeletar) {
		this.painelAlterarDeletar = painelAlterarDeletar;
	}

	public JLabel getTextoAno() {
		return textoAno;
	}

	public void setTextoAno(JLabel textoAno) {
		this.textoAno = textoAno;
	}

	public JLabel getTextoEdicao() {
		return textoEdicao;
	}

	public void setTextoEdicao(JLabel textoEdicao) {
		this.textoEdicao = textoEdicao;
	}

	public JLabel getTextoTitulo() {
		return textoTitulo;
	}

	public void setTextoTitulo(JLabel textoTitulo) {
		this.textoTitulo = textoTitulo;
	}

	public JLabel getTextoLocal() {
		return textoLocal;
	}

	public void setTextoLocal(JLabel textoLocal) {
		this.textoLocal = textoLocal;
	}

	public JLabel getTextoEditora() {
		return textoEditora;
	}

	public void setTextoEditora(JLabel textoEditora) {
		this.textoEditora = textoEditora;
	}

	public JLabel getTextoIdAlterar() {
		return textoIdAlterar;
	}

	public void setTextoIdAlterar(JLabel textoIdAlterar) {
		this.textoIdAlterar = textoIdAlterar;
	}

	public JTextField getCampoIdAlterar() {
		return campoIdAlterar;
	}

	public void setCampoIdAlterar(JTextField campoIdAlterar) {
		this.campoIdAlterar = campoIdAlterar;
	}

	public JLabel getTextoAnoAlterar() {
		return textoAnoAlterar;
	}

	public void setTextoAnoAlterar(JLabel textoAnoAlterar) {
		this.textoAnoAlterar = textoAnoAlterar;
	}

	public JTextField getCampoAnoAlterar() {
		return campoAnoAlterar;
	}

	public void setCampoAnoAlterar(JTextField campoAnoAlterar) {
		this.campoAnoAlterar = campoAnoAlterar;
	}

	public JLabel getTextoEdicaoAlterar() {
		return textoEdicaoAlterar;
	}

	public void setTextoEdicaoAlterar(JLabel textoEdicaoAlterar) {
		this.textoEdicaoAlterar = textoEdicaoAlterar;
	}

	public JTextField getCampoEdicaoAlterar() {
		return campoEdicaoAlterar;
	}

	public void setCampoEdicaoAlterar(JTextField campoEdicaoAlterar) {
		this.campoEdicaoAlterar = campoEdicaoAlterar;
	}

	public JLabel getTextoTituloAlterar() {
		return textoTituloAlterar;
	}

	public void setTextoTituloAlterar(JLabel textoTituloAlterar) {
		this.textoTituloAlterar = textoTituloAlterar;
	}

	public JTextField getCampoTituloAlterar() {
		return campoTituloAlterar;
	}

	public void setCampoTituloAlterar(JTextField campoTituloAlterar) {
		this.campoTituloAlterar = campoTituloAlterar;
	}

	public JLabel getTextoLocalAlterar() {
		return textoLocalAlterar;
	}

	public void setTextoLocalAlterar(JLabel textoLocalAlterar) {
		this.textoLocalAlterar = textoLocalAlterar;
	}

	public JTextField getCampoLocalAlterar() {
		return campoLocalAlterar;
	}

	public void setCampoLocalAlterar(JTextField campoLocalAlterar) {
		this.campoLocalAlterar = campoLocalAlterar;
	}

	public JLabel getTextoEditoraAlterar() {
		return textoEditoraAlterar;
	}

	public void setTextoEditoraAlterar(JLabel textoEditoraAlterar) {
		this.textoEditoraAlterar = textoEditoraAlterar;
	}

	public JTextField getCampoEditoraAlterar() {
		return campoEditoraAlterar;
	}

	public void setCampoEditoraAlterar(JTextField campoEditoraAlterar) {
		this.campoEditoraAlterar = campoEditoraAlterar;
	}
	
	//=====================================================
	
	
	
}
