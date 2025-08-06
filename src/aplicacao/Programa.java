
import xadrez.ChessMatch;
import xadrez.ChessPiece;
import xadrez.ChessPosition;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true){
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(scanner);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(scanner);

            ChessPiece capturedPiece = chessMatch.performChessMove(source,target);
        }

    }
}