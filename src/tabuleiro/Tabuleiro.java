package tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new ExcecaoDeTabuleiro("Erro criando tabuleiro. � necessario que aja pelo menos uma linha e uma coluna.");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}
	public int getLinhas() {
		return linhas;
	}
	
	public int getColunas() {
		return colunas;
	}

	
	public Peca peca (int linha, int coluna) {
		if(!posicaoExistente(linha, coluna)) {
			throw new ExcecaoDeTabuleiro("Posi��o inexistente no tabuleiro");
		}
		return pecas[linha][coluna];
		
	}
	public Peca peca (Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new ExcecaoDeTabuleiro("Posi��o inexistente no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
		
	}
	
	public void colocarPeca(Peca peca, Posicao posicao) {
		if(posicaoOcupada(posicao)) {
			throw new ExcecaoDeTabuleiro("J� existe uma pe�a na posicao" + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean posicaoExistente(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean posicaoOcupada(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new ExcecaoDeTabuleiro("Posi��o inexistente no tabuleiro");
		}
		return peca(posicao) != null;
		
	}
}
