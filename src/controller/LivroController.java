package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.LivroDAO;
import model.Livro;
import view.LivroView;

public class LivroController {
	private LivroView view = new LivroView();
	
	public LivroController() {
		MouseListener ouvinte2 = new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == view.getTabela()) {
					//tabela
		            int linha = view.getTabela().getSelectedRow();
		            
		            int id = (int) view.getTabela().getValueAt(linha, 0);
		            int ano = (int) view.getTabela().getValueAt(linha, 1);
		            int edicao = (int) view.getTabela().getValueAt(linha, 2);
		            String titulo = (String) view.getTabela().getValueAt(linha, 3);
		            String local = (String) view.getTabela().getValueAt(linha, 4);
		            String editora = (String) view.getTabela().getValueAt(linha, 5);
		            view.getCampoIdAlterar().setText( String.format("%d", id) );
		            view.getCampoAnoAlterar().setText(String.format("%d", ano));
		            view.getCampoEdicaoAlterar().setText(String.format("%d", edicao));
		            view.getCampoTituloAlterar().setText(titulo);
		            view.getCampoLocalAlterar().setText(local);
		            view.getCampoEditoraAlterar().setText(editora);
		            view.getBotaoAlterar().setEnabled(true);
		            view.getBotaoDeletar().setEnabled(true);
				}
			}
		};

		ActionListener ouvinte = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == view.getBotaoSalvar()) {
					// salvar
					Livro livros = new Livro();
					livros.setAno(Integer.parseInt(view.getCampoAno().getText()));
					livros.setEdicao(Integer.parseInt(view.getCampoEdicao().getText()));
					livros.setTitulo(view.getCampoTitulo().getText());
					livros.setLocal(view.getCampoLocal().getText());
					livros.setEditora(view.getCampoEditora().getText());
					
					LivroDAO dao = new LivroDAO();
					dao.salvar(livros);
					
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					List<Livro> listaCelulares = dao.listar();
					view.carregarTabela(listaCelulares,ouvinte2);
					view.limparCampos();
				}else
					if(e.getSource() == view.getBotaoAlterar()) {
						// alterar
						Livro livros = new Livro();
						String id = view.getCampoIdAlterar().getText();
						if(!id.equals("")) {
							livros.setId(Integer.parseInt(id));
							livros.setAno(Integer.parseInt(view.getCampoAnoAlterar().getText()));
							livros.setEdicao(Integer.parseInt(view.getCampoEdicaoAlterar().getText()));
							livros.setTitulo(view.getCampoTituloAlterar().getText());
							livros.setLocal(view.getCampoLocalAlterar().getText());
							livros.setEditora(view.getCampoEditoraAlterar().getText());
							
							LivroDAO dao = new LivroDAO();
							dao.alterar(livros);
							
							JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
							List<Livro> listaLivros = dao.listar();
							view.carregarTabela(listaLivros,ouvinte2);
							view.limparCampos();
						}
					}else
						if(e.getSource() == view.getBotaoDeletar()) {
							// deletar
							String id = view.getCampoIdAlterar().getText();
							if(!id.equals("")) {
								LivroDAO dao = new LivroDAO();
								dao.deletar(Integer.parseInt(id));
								JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
								List<Livro> listaLivros = dao.listar();
								view.carregarTabela(listaLivros,ouvinte2);
								view.limparCampos();
							}
						}

			}
		};

		view.configurarComponentes(ouvinte);

		LivroDAO dao = new LivroDAO();
		List<Livro> listaCelulares = dao.listar();
		view.carregarTabela(listaCelulares,ouvinte2);
	}
	}

