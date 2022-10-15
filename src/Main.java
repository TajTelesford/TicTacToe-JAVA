import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        char player1 = 'O', player2 = 'X', currentPLayer = player1, currentPLayerMove;
        int boardSize = 3;
        Scanner scanInput = new Scanner(System.in);

        //Initializing Board
        ArrayList<List<Character>> grid_list = new ArrayList<>();
        grid_list.add(Arrays.asList('1','2','3'));
        grid_list.add(Arrays.asList('4','5','6'));
        grid_list.add(Arrays.asList('7','8','9'));

        //Game Loop
        while(morePositions(grid_list, boardSize))
        {
            drawGrid(grid_list, boardSize);
            currentPLayerMove = playerMove(scanInput, currentPLayer, boardSize, grid_list);
            pickSpot(grid_list, currentPLayer, currentPLayerMove, boardSize);
            if(checkWin(grid_list,currentPLayer, boardSize))
                break;
            if(currentPLayer == player1)
                currentPLayer = player2;
            else
                currentPLayer = player1;
        }
        drawGrid(grid_list, boardSize);
        System.out.println("NO WINNER :(");
    }

    //Draws Board
    public static void drawGrid(ArrayList<List<Character>> grid, int size)
    {
        for(int i = 0; i < size; i++)
        {
            for(Character pos : grid.get(i))
            {
                System.out.print(pos + " ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    //Picks The Players Spot
    public static void pickSpot(ArrayList<List<Character>> grid, char player, char choice, int size)
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(grid.get(i).get(j) == choice)
                    grid.get(i).set(j, player);
            }
        }
    }

    //Checks If Player X or Player O Won The Game
    public static boolean checkWin(ArrayList<List<Character>> grid, char player, int size)
    {
        // Checking rows
        if(grid.get(0).get(0) == player && grid.get(0).get(1) == player && grid.get(0).get(2) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }
        if(grid.get(1).get(0) == player && grid.get(1).get(1) == player && grid.get(1).get(2) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }
        if(grid.get(2).get(0) == player && grid.get(2).get(1) == player && grid.get(2).get(2) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }

        //Columns
        if(grid.get(0).get(0) == player && grid.get(1).get(0) == player && grid.get(2).get(0) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }
        if(grid.get(0).get(1) == player && grid.get(1).get(1) == player && grid.get(2).get(1) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }
        if(grid.get(0).get(2) == player && grid.get(1).get(2) == player && grid.get(2).get(2) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }

        //diagonals
        if(grid.get(0).get(0) == player && grid.get(1).get(1) == player && grid.get(2).get(2) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }
        if(grid.get(0).get(2) == player && grid.get(1).get(1) == player && grid.get(2).get(0) == player)
        {
            drawGrid(grid, size);
            System.out.println(player + " YOU HAVE WON");
            return true;
        }
        return false;
    }

    //Checks If The Position The Player Picked Is Valid, If Not Keeps Going Until Valid
    public static boolean checkPosition(ArrayList<List<Character>> grid, char input, int size)
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(grid.get(i).get(j) == input)
                    return true;
            }
        }
        return false;
    }

    //Where The User Chooses Their Position On The Board
    public static char playerMove(Scanner playerInput, char player, int size, ArrayList<List<Character>> grid)
    {
        System.out.println("Player " + player + " Make a Move 1 - 9: ");
        char move;
        do{
            String input = playerInput.next();
            move = input.charAt(0);
        }while(!checkPosition(grid, move, size));


        return move;
    }
    public static boolean morePositions(ArrayList<List<Character>> grid, int size)
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(grid.get(i).get(j) == '1'||
                        grid.get(i).get(j) == '2'||
                        grid.get(i).get(j) == '3'||
                        grid.get(i).get(j) == '4'||
                        grid.get(i).get(j) == '5'||
                        grid.get(i).get(j) == '6'||
                        grid.get(i).get(j) == '7'||
                        grid.get(i).get(j) == '8'||
                        grid.get(i).get(j) == '9')
                    return true;
            }
        }
        return false;
    }
}