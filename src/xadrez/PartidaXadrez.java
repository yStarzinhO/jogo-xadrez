package xadrez;

import tabuleiro.Peca;
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
	
	public PecaXadrez movimentarPecaXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		Peca capturarPeca = fazerMover(origem, destino);
		return (PecaXadrez) capturarPeca;
	}
	
	private Peca fazerMover(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.posicaoExistente(posicao)) {
			throw new ExcecaoDeXadrez("Não existe peça na posição de origem.");
		}
		if(tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new ExcecaoDeXadrez("Não existe movimentos possiveis para a peça escolhida.");
			
		}
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


