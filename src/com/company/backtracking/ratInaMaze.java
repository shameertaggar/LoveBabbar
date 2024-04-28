package com.company.backtracking;

import java.util.ArrayList;

public class ratInaMaze {
    public static void main(String[] args) {
        int maze[][] = {
                {1,0,0,0},
                {1,1,0,0},
                {1,1,1,0},
                {1,1,1,1}
        };

        int row = 4;
        int col = 4;
        int srcX = 0;
        int srcY = 0;
        String output = "";

        ArrayList<ArrayList<Boolean>> bool = new ArrayList<>(row);

        for (int i = 0; i < row; i++) {
            ArrayList<Boolean> innerList = new ArrayList<>(col);
            for (int j = 0; j < col; j++) {
                innerList.add(false);
            }
            bool.add(innerList);
        }
        solve(maze,row,col,srcX,srcY,output,bool);
    }

    private static void solve(int[][] maze, int row, int col, int srcX, int srcY, String output, ArrayList<ArrayList<Boolean>> bool) {
        if (srcX == row-1 && srcY == col-1){
            System.out.println(output);
            return;
        }
        //up
        int newX = srcX-1;
        int newY = srcY;
        if (isSafe(srcX,srcY,newX,newY,maze,row,col,bool)){
            bool.get(newX).set(newY, true);
            solve(maze, row, col, newX, newY, output+ 'U', bool);
            bool.get(newX).set(newY, false);
        }
        //right
        newX = srcX;
        newY = srcY+1;
        if (isSafe(srcX,srcY,newX,newY,maze,row,col,bool)){
            bool.get(newX).set(newY, true);
            solve(maze, row, col, newX, newY, output+ 'R', bool);
            bool.get(newX).set(newY, false);
        }
        //left
        newX = srcX;
        newY = srcY-1;
        if (isSafe(srcX,srcY,newX,newY,maze,row,col,bool)){
            bool.get(newX).set(newY, true);
            solve(maze, row, col, newX, newY, output+ 'L', bool);
            bool.get(newX).set(newY, false);
        }
        //down
        newX = srcX+1;
        newY = srcY;
        if (isSafe(srcX,srcY,newX,newY,maze,row,col,bool)){
            bool.get(newX).set(newY, true);
            solve(maze, row, col, newX, newY, output+ 'D', bool);
            bool.get(newX).set(newY, false);
        }

    }

    private static Boolean isSafe(int srcX, int srcY, int newX, int newY, int[][] maze, int row, int col, ArrayList<ArrayList<Boolean>> visited){
        if ((newX >= 0 && newX < row) && (newY >= 0 && newY < col) && (maze[newX][newY] == 1) && !visited.get(newX).get(newY)) {
            return true;
        }

        return false;
    }
}
