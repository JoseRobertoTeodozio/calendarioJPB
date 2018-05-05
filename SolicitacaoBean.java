package com.calendariojpb.bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.calendariojpb.dao.SolicitacaoDAO;
import com.calendariojpb.domain.Solicitacao;
import com.calendariojpb.utl.JSFUtil;

@ManagedBean(name = "MBsolicitacao")
@ViewScoped
public class SolicitacaoBean {

	private Solicitacao solicitacao;

	public Solicitacao getSolicitcao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public void prepararSolicitacao() {
		solicitacao = new Solicitacao();
	}

	public void salvar() {

		try {
			SolicitacaoDAO dao = new SolicitacaoDAO();
			dao.salvar(solicitacao);
			JSFUtil.adicionarMensagemSucesso("Solicitação enviada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}

}
