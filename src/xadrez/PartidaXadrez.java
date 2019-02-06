package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
		
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void setupInicial() {

		colocarNovaPeca('C', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('C', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('D', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('E', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('E', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('D', 1, new Rei(tabuleiro, Cor.BRANCA));

		colocarNovaPeca('C', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('C', 8, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('D', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('E', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('E', 8, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('D', 8, new Rei(tabuleiro, Cor.PRETA));
	}

	}


