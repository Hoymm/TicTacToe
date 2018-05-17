package data.board;

import data.Symbol;

class BoardDrawer {


    String getDisplayLine_withSymbolOrNumberInsideField(BoardData gameBoardData, int fieldCounter) {
        StringBuilder displayLineWithEmptySpaces = new StringBuilder();
        for (int i = 0; i < gameBoardData.width; ++i) {
            Symbol symbolOnField = gameBoardData.getSymbolFromField(fieldCounter);

            displayLineWithEmptySpaces.append("|");

            if (symbolOnField != null || String.valueOf(fieldCounter).length() < 3) {
                displayLineWithEmptySpaces.append(" ");
            }

            displayLineWithEmptySpaces.append(symbolOnField == null ? fieldCounter : symbolOnField);

            if (symbolOnField != null || String.valueOf(fieldCounter).length() < 2) {
                displayLineWithEmptySpaces.append(" ");
            }

            ++fieldCounter;
        }
        return displayLineWithEmptySpaces.append("|").toString();
    }

    String getDisplayTopLineOfBoard(BoardData gameBoardData) {
        return new String(new char[gameBoardData.width*4+1]).replace("\0", "_");
    }

    String getDisplayLine_verticalSeparatorBetweenFields(BoardData gameBoardData) {
        return getHorizontalLineOfBoardDisplayWithHorizontalSeparators(gameBoardData, "___");
    }

    String getDisplayLine_withEmptySpacesInsideField(BoardData gameBoardData) {
        return getHorizontalLineOfBoardDisplayWithHorizontalSeparators(gameBoardData, "   ");
    }

    private String getHorizontalLineOfBoardDisplayWithHorizontalSeparators(BoardData gameBoardData, String spaceBetweenSeparators) {
        StringBuilder displayLineWithEmptySpaces = new StringBuilder();
        for (int i = 0; i < gameBoardData.width; ++i) {
            displayLineWithEmptySpaces.append("|")
                    .append(spaceBetweenSeparators);
        }
        return displayLineWithEmptySpaces.append("|").toString();
    }

    String calculateStringDisplayingGameBoard(BoardData gameBoardData) {
        StringBuilder tableDisplayInfoBuilder = new StringBuilder();
        tableDisplayInfoBuilder.append(getDisplayTopLineOfBoard(gameBoardData)).append("\n");

        int curFirstLeftColumnNumber = 1;
        for (int levelCountingFromTop = 0; levelCountingFromTop < gameBoardData.height; ++levelCountingFromTop){
            tableDisplayInfoBuilder
                    .append(getDisplayLine_withEmptySpacesInsideField(gameBoardData)).append("\n")
                    .append(getDisplayLine_withSymbolOrNumberInsideField(gameBoardData, curFirstLeftColumnNumber)).append("\n")
                    .append(getDisplayLine_verticalSeparatorBetweenFields(gameBoardData)).append("\n");
            curFirstLeftColumnNumber += gameBoardData.width;
        }
        return tableDisplayInfoBuilder.toString();
    }

}
