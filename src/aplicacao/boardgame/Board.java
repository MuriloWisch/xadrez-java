package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1 ){
            throw new BoardException("Erro criando tabuleiro, é necessario que aja 1 coluna e 1 linha");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if (!positionExists(row, column)) {
            throw new BoardException("Posição não esta no tabuleiro");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Posição não esta no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiace(position)) {
            throw new BoardException("Ja existe uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row,int column){
       return row >= 0 && row < rows && columns >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(),position.getColumn());
    }

    public boolean thereIsAPiace(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Posição não esta no tabuleiro");
        }
        return piece(position) != null;
    }
}
