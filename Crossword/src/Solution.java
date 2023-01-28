
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //detectAllWords(crossword, "home", "same");
        /*HashSet <Character> set = new HashSet<>();
        for (int[] c : crossword) {
            for(int cc : c) {
                set.add((char) cc);
            }
        }
        //System.out.println(set);
        System.out.println(crossword[0].length);
        for (Character c: set) {
            List<Symbol> symbol = findSymbol(c, crossword);
            System.out.println();
            for (Symbol s : symbol) {
                System.out.print(s);
            }
        }
*/

        //Symbol symbol1 = lookAround(symbol, 'e', crossword);
        //System.out.println(symbol1);
        /*int
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> lword = new ArrayList<>();
        for (String word : words) {
            char[] sym = word.toCharArray();
            for (int i = 0; i < sym.length; i++) {
                if (i == 0) {
                    //Symbol first = findSymbol(sym[i], crossword);
                }
            }
        }
        return null;
    }
//не правильно работет разберись с e
    public static List<Symbol> findSymbol(char c, int[][] crossword) {
        List<Symbol> symbol = new ArrayList<>();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                if (c == crossword[i][j]) {
                    Symbol symbol1 = new Symbol(c);
                    symbol1.setX(j);
                    symbol1.setY(i);
                    symbol.add(symbol1);

                }
            }
        }
        return symbol;
    }
//lookAround должен возвращать массив символов со всеми возможными вариантами
    public static Symbol lookAround(Symbol symbol, char c, int[][] crossword) {
        Symbol fsymbol = new Symbol(c);
        int maxy = crossword.length - 1;
        int maxx= crossword[0].length - 1;
        // граничный случай левый верхний угол матрицы
        if (symbol.x == 0 && symbol.y == 0) {
            if (crossword[1][0] == c) {
                fsymbol.x = 0;
                fsymbol.y = 1;
            } else if (crossword[0][1] == c) {
                fsymbol.x = 1;
                fsymbol.y = 0;
            } else if (crossword[1][1] == c) {
                fsymbol.x = 1;
                fsymbol.y = 1;
            }
            //граничный случай правый нижний край матрицы
        } else if (symbol.x == maxx && symbol.y == maxy) {
            if (crossword[maxy - 1][maxx - 1] == c) {
                fsymbol.x = maxx - 1;
                fsymbol.y = maxy - 1;
            } else if (crossword[maxy - 1][maxx] == c) {
                fsymbol.x = maxx - 1;
                fsymbol.y = maxy;
            } else if (crossword[maxy][maxx - 1] == c) {
                fsymbol.x = maxx;
                fsymbol.y = maxy - 1;
            }
            //граничный случай правый верхний угол матрицы
        } else if (symbol.x == maxx && symbol.y == 0) {
            if (crossword[0][maxx - 1] == c) {
                fsymbol.x = maxx - 1;
                fsymbol.y = 0;
            } else if (crossword[1][maxx] == c) {
                fsymbol.x = maxx;
                fsymbol.y = 1;
            } else if (crossword[1][maxx - 1] == c) {
                fsymbol.x = maxx - 1;
                fsymbol.y = 1;
            }
            //граничный случай левый нижний угол матрицы
        } else if (symbol.x == 0 && symbol.y == maxy) {
            if (crossword[maxy - 1][0] == c) {
                fsymbol.x = 0;
                fsymbol.y = maxy - 1;
            } else if (crossword[maxy][1] == c) {
                fsymbol.x = 1;
                fsymbol.y = maxy;
            } else if (crossword[maxy - 1][1] == c) {
                fsymbol.x = 1;
                fsymbol.y = maxy - 1;
            }
            //граничный случай левый край матрицы
        } else if (symbol.x == 0) {
            if (crossword[symbol.y - 1][0] == c) {
                fsymbol.x = 0;
                fsymbol.y = symbol.y - 1;
            } else if (crossword[symbol.y - 1][1] == c) {
                fsymbol.x = 1;
                fsymbol.y = symbol.y - 1;
            } else if (crossword[symbol.y][1] == c) {
                fsymbol.x = 1;
                fsymbol.y = symbol.y;
            } else if (crossword[symbol.y + 1][1] == c) {
                fsymbol.x = 1;
                fsymbol.y = symbol.y + 1;
            } else if (crossword[symbol.y + 1][0] == c) {
                fsymbol.x = 0;
                fsymbol.y = symbol.y + 1;
            }
            //граничный случай правый край матрицы
        } else if (symbol.x == maxx) {
            if (crossword[symbol.y - 1][maxx] == c) {
                fsymbol.x = maxx;
                fsymbol.y = symbol.y - 1;
            } else if (crossword[symbol.y - 1][maxx - 1] == c) {
                fsymbol.x = maxx - 1;
                fsymbol.y = symbol.y - 1;
            } else if (crossword[symbol.y][maxx - 1] == c) {
                fsymbol.x = maxx - 1;
                fsymbol.y = symbol.y;
            } else if (crossword[symbol.y + 1][maxx + 1] == c) {
                fsymbol.x = maxx + 1;
                fsymbol.y = symbol.y + 1;
            } else if (crossword[symbol.y + 1][maxx] == c) {
                fsymbol.x = maxx;
                fsymbol.y = symbol.y + 1;
            }
            //граничный случай верхний край матрицы
        } else if (symbol.y == 0) {
            if (crossword[0][symbol.x - 1] == c) {
                fsymbol.x = symbol.x - 1;
                fsymbol.y = 0;
            } else if (crossword[1][symbol.x - 1] == c) {
                fsymbol.x = symbol.x - 1;
                fsymbol.y = 1;
            } else if (crossword[1][symbol.x] == c) {
                fsymbol.x = symbol.x;
                fsymbol.y = 1;
            } else if (crossword[1][symbol.x + 1] == c) {
                fsymbol.x = symbol.x + 1;
                fsymbol.y = 1;
            } else if (crossword[0][symbol.x + 1] == c) {
                fsymbol.x = symbol.x + 1;
                fsymbol.y = 0;
            }
            //граничный случай нижний край матрицы
        } else if (symbol.y == maxy) {
            if (crossword[maxy][symbol.x - 1] == c) {
                fsymbol.x = symbol.x - 1;
                fsymbol.y = maxy;
            } else if (crossword[maxy - 1][symbol.x - 1] == c) {
                fsymbol.x = symbol.x - 1;
                fsymbol.y = maxy - 1;
            } else if (crossword[maxy - 1][symbol.x] == c) {
                fsymbol.x = symbol.x;
                fsymbol.y = maxy - 1;
            } else if (crossword[maxy - 1][symbol.x + 1] == c) {
                fsymbol.x = symbol.x + 1;
                fsymbol.y = maxy - 1;
            } else if (crossword[maxy][symbol.x + 1] == c) {
                fsymbol.x = symbol.x + 1;
                fsymbol.y = maxy;
            }
            //общий случай
        } else {
            if (crossword[symbol.y - 1][symbol.x - 1] == c) {
                fsymbol.x = symbol.x - 1;
                fsymbol.y = symbol.y - 1;
            } else if (crossword[symbol.y][symbol.x - 1] == c) {
                fsymbol.x = symbol.x - 1;
                fsymbol.y = symbol.y;
            } else if (crossword[symbol.y + 1][symbol.x - 1] == c) {
                fsymbol.x = symbol.x - 1;
                fsymbol.y = symbol.y + 1;
            } else if (crossword[symbol.y + 1][symbol.x] == c) {
                fsymbol.x = symbol.x;
                fsymbol.y = symbol.y + 1;
            } else if (crossword[symbol.y + 1][symbol.x + 1] == c) {
                fsymbol.x = symbol.x + 1;
                fsymbol.y = symbol.y + 1;
            } else if (crossword[symbol.y][symbol.x + 1] == c) {
                fsymbol.x = symbol.x + 1;
                fsymbol.y = symbol.y;
            } else if (crossword[symbol.y - 1][symbol.x + 1] == c) {
                fsymbol.x = symbol.x + 1;
                fsymbol.y = symbol.y - 1;
            } else if (crossword[symbol.y - 1][symbol.x] == c) {
                fsymbol.x = symbol.x;
                fsymbol.y = symbol.y - 1;
            }
        }
        return fsymbol;
    }

    public static class Symbol {
        private final char sym;
        private int x;
        private int y;

        public Symbol(char c) {
            this.sym = c;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return sym + "(" + x + "," + y + ")";
        }

    }

    public static class Word {
        private final String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
