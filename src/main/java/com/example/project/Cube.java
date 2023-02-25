import java.util.Scanner;

public class Cube {

    public static void inputf(String [][][] Rcube) {
Scanner in = new Scanner(System.in);
        while(true){
        
            String input = in.next();
            if(input.equals("done")) {
                break;
            }
        move(Rcube, input);
        }
        in.close();
        }

    static String Solution = "";{

    };


    static String[][] face = {
        {"1","2","3"},
        {"4","5","6"},
        {"7","8","9"}
    };
    static String[][][] Rcube = {
        {
            {"r","r","r"},
            {"r","r","r"},
            {"r","r","r"}
        },
        { 
            {"b","b","b"},
            {"b","b","b"},
            {"b","b","b"}

            
        },
        {
            {"o","o","o"},
            {"o","o","o"},
            {"o","o","o"}
        },
        {
            {"g","g","g"},
            {"g","g","g"},
            {"g","g","g"}
        },
        {
            {"y","y","y"},
            {"y","y","y"},
            {"y","y","y"}
        },
        {
            {"w","w","w"},
            {"w","w","w"},
            {"w","w","w"}
        },
    };


    static void show(String[][][] cube){
        for(int i=0; i<6;i++){
            for(int j=0; j<3;j++){
                for(int k=0; k<3;k++){
                        System.out.print(cube[i][j][k]);
                        if (k < 2){
                            System.out.print("|");
                        }
                        // else{
                        //     break;
                        // }

                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void show(String[][] Face){
        for(String[] i: Face){
            for(String j: i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    static void move(String[][][] cube, String input){
        // String[][][] tempCube = new String[6][3][3];

        // for(int i=0; i<3;i++)
        //     for(int j=0; j<3;j++)
        //         for(int k=0; k<3;k++)
        //             tempCube[i][j][k] = Cube[i][j][k];
        // int a;
        // int b;
        switch(input){
            case "u":
            rotateFaceCube(cube, true, 4 );
            Solution = Solution + " u'";
            show(cube);
            System.out.println(Solution);
            break;
        case "u'":
            rotateFaceCube(cube, false, 4 );
            Solution = Solution + " u";
            show(cube);
            System.out.println(Solution);
            break;
        case "l":
            rotateFaceCube(cube, true, 2 );
            Solution = Solution + " l'";
            show(cube);
            System.out.println(Solution);
            break;
        case "l'":
            rotateFaceCube(cube, false, 2 );
            Solution = Solution + " l";
            show(cube);
            System.out.println(Solution);
            break;
        case "f":
            rotateFaceCube(cube, true, 1 );
            Solution = Solution + " f'";
            show(cube);
            System.out.println(Solution);
            break;
        case "f'": 
            rotateFaceCube(cube, false, 1 );
            Solution = Solution + " f";
            show(cube);
            System.out.println(Solution);
            break;
        case "r":
            rotateFaceCube(cube, true, 0 );
            Solution = Solution + " r'";
            show(cube);
            System.out.println(Solution);
            break;
        case "r'":
            rotateFaceCube(cube, false, 0 );
            Solution = Solution + " r";
            show(cube);
            System.out.println(Solution);
            break;
        case "d":
            rotateFaceCube(cube, true, 5 );
            Solution = Solution + " d'";
            show(cube);
            System.out.println(Solution);
            break;
        case "d'":
            rotateFaceCube(cube, false, 5 );
            Solution = Solution + " d";
            show(cube);
            System.out.println(Solution);
            break;
        case "b":
            rotateFaceCube(cube, true, 3 );
            Solution = Solution + " b'";
            show(cube);
            System.out.println(Solution);
            break;
        case "b'":
            rotateFaceCube(cube, false, 3 );
            Solution = Solution + " b'";
            show(cube);
            System.out.println(Solution);
            break;
        default:
            break;
        }




    }

    static void rotateFaceCube(String[][][] cube, boolean clockwise, int side){
        int a;
        int b;
        String[][][] tempCube = new String[6][3][3];
        for(int i=0; i<6;i++)
            for(int j=0; j<3;j++)
                for(int k=0; k<3;k++)
                    tempCube[i][j][k] = cube[i][j][k];
    
        if(clockwise){  
            for(int i=0; i<9;i++){
                a = i/3;
                b = 2;
                for(int j=0; j<3;j++){
                     cube[side][a][j] = tempCube[side][b][a];
                    b--;
                }
            }

            switch(side){
                case 0:
                cube[1][2][2] = tempCube[5][2][2];
                cube[1][1][2] = tempCube[5][1][2];
                cube[1][0][2] = tempCube[5][0][2];

                cube[3][0][0] = tempCube[4][2][2];
                cube[3][1][0] = tempCube[4][1][2];
                cube[3][2][0] = tempCube[4][0][2];

                cube[4][2][2] = tempCube[1][2][2];
                cube[4][1][2] = tempCube[1][1][2];
                cube[4][0][2] = tempCube[1][0][2];
                
                cube[5][2][2] = tempCube[3][0][0];
                cube[5][1][2] = tempCube[3][1][0];
                cube[5][0][2] = tempCube[3][2][0];

                break;
                case 1:
                cube[5][0][2] = tempCube[0][0][0];
                cube[5][0][1] = tempCube[0][1][0];
                cube[5][0][0] = tempCube[0][2][0];

                cube[2][2][2] = tempCube[5][0][2];
                cube[2][1][2] = tempCube[5][0][1];
                cube[2][0][2] = tempCube[5][0][0];

                cube[4][2][2] = tempCube[2][0][2];
                cube[4][2][1] = tempCube[2][1][2];
                cube[4][2][0] = tempCube[2][2][2];
                
                cube[0][0][0] = tempCube[4][2][0];
                cube[0][1][0] = tempCube[4][2][1];
                cube[0][2][0] = tempCube[4][2][2];

                break;
                case 2:
                cube[5][0][0] = tempCube[1][0][0];
                cube[5][1][0] = tempCube[1][1][0];
                cube[5][2][0] = tempCube[1][2][0];

                cube[3][2][2] = tempCube[5][0][0];
                cube[3][1][2] = tempCube[5][1][0];
                cube[3][0][2] = tempCube[5][2][0];

                cube[4][0][0] = tempCube[3][2][2];
                cube[4][1][0] = tempCube[3][1][2];
                cube[4][2][0] = tempCube[3][0][2];
                
                cube[1][0][0] = tempCube[4][0][0];
                cube[1][1][0] = tempCube[4][1][0];
                cube[1][2][0] = tempCube[4][2][0];

                break;
                case 3:
                cube[0][0][2] = tempCube[5][2][2];
                cube[0][1][2] = tempCube[5][2][1];
                cube[0][2][2] = tempCube[5][2][0];

                cube[5][2][0] = tempCube[2][0][0];
                cube[5][2][1] = tempCube[2][1][0];
                cube[5][2][2] = tempCube[2][2][0];

                cube[2][0][0] = tempCube[4][0][2];
                cube[2][1][0] = tempCube[4][0][1];
                cube[2][2][0] = tempCube[4][0][0];
                
                cube[4][0][0] = tempCube[0][0][2];
                cube[4][0][1] = tempCube[0][1][2];
                cube[4][0][2] = tempCube[0][2][2];

                break;
                case 4:
                cube[1][0][0] = tempCube[0][0][0];
                cube[1][0][1] = tempCube[0][0][1];
                cube[1][0][2] = tempCube[0][0][2];

                cube[2][0][0] = tempCube[1][0][0];
                cube[2][0][1] = tempCube[1][0][1];
                cube[2][0][2] = tempCube[1][0][2];

                cube[3][0][0] = tempCube[2][0][0];
                cube[3][0][1] = tempCube[2][0][1];
                cube[3][0][2] = tempCube[2][0][2];
                
                cube[0][0][0] = tempCube[3][0][0];
                cube[0][0][1] = tempCube[3][0][1];
                cube[0][0][2] = tempCube[3][0][2];

                break;
                case 5:
                cube[0][2][0] = tempCube[1][2][0];
                cube[0][2][1] = tempCube[1][2][1];
                cube[0][2][2] = tempCube[1][2][2];

                cube[1][2][0] = tempCube[2][2][0];
                cube[1][2][1] = tempCube[2][2][1];
                cube[1][2][2] = tempCube[2][2][2];

                cube[2][2][0] = tempCube[3][2][0];
                cube[2][2][1] = tempCube[3][2][1];
                cube[2][2][2] = tempCube[3][2][2];
                
                cube[3][2][0] = tempCube[0][2][0];
                cube[3][2][1] = tempCube[0][2][1];
                cube[3][2][2] = tempCube[0][2][2];
                break;
            }
            
        }else{
            for(int i=0; i<9;i++){
                a = i/3;
                b = 2;
                for(int j=0; j<3;j++){

                    cube[side][b][a] = tempCube[side][a][j];
                    b--;
            
                }  
                

            }
            for(int t = 0; t < 3; t++){
                for(int i=0; i<6;i++)
            for(int j=0; j<3;j++)
                for(int k=0; k<3;k++)
                    tempCube[i][j][k] = cube[i][j][k];
                switch(side){
                case 0:
                cube[1][2][2] = tempCube[5][2][2];
                cube[1][1][2] = tempCube[5][1][2];
                cube[1][0][2] = tempCube[5][0][2];

                cube[3][0][0] = tempCube[4][2][2];
                cube[3][1][0] = tempCube[4][1][2];
                cube[3][2][0] = tempCube[4][0][2];

                cube[4][2][2] = tempCube[1][2][2];
                cube[4][1][2] = tempCube[1][1][2];
                cube[4][0][2] = tempCube[1][0][2];
                
                cube[5][2][2] = tempCube[3][0][0];
                cube[5][1][2] = tempCube[3][1][0];
                cube[5][0][2] = tempCube[3][2][0];

                break;
                case 1:
                cube[5][0][2] = tempCube[0][0][0];
                cube[5][0][1] = tempCube[0][1][0];
                cube[5][0][0] = tempCube[0][2][0];

                cube[2][2][2] = tempCube[5][0][2];
                cube[2][1][2] = tempCube[5][0][1];
                cube[2][0][2] = tempCube[5][0][0];

                cube[4][2][2] = tempCube[2][0][2];
                cube[4][2][1] = tempCube[2][1][2];
                cube[4][2][0] = tempCube[2][2][2];
                
                cube[0][0][0] = tempCube[4][2][0];
                cube[0][1][0] = tempCube[4][2][1];
                cube[0][2][0] = tempCube[4][2][2];

                break;
                case 2:
                cube[5][0][0] = tempCube[1][0][0];
                cube[5][1][0] = tempCube[1][1][0];
                cube[5][2][0] = tempCube[1][2][0];

                cube[3][2][2] = tempCube[5][0][0];
                cube[3][1][2] = tempCube[5][1][0];
                cube[3][0][2] = tempCube[5][2][0];

                cube[4][0][0] = tempCube[3][2][2];
                cube[4][1][0] = tempCube[3][1][2];
                cube[4][2][0] = tempCube[3][0][2];
                
                cube[1][0][0] = tempCube[4][0][0];
                cube[1][1][0] = tempCube[4][1][0];
                cube[1][2][0] = tempCube[4][2][0];

                break;
                case 3:
                cube[0][0][2] = tempCube[5][2][2];
                cube[0][1][2] = tempCube[5][2][1];
                cube[0][2][2] = tempCube[5][2][0];

                cube[5][2][0] = tempCube[2][0][0];
                cube[5][2][1] = tempCube[2][1][0];
                cube[5][2][2] = tempCube[2][2][0];

                cube[2][0][0] = tempCube[4][0][2];
                cube[2][1][0] = tempCube[4][0][1];
                cube[2][2][0] = tempCube[4][0][0];
                
                cube[4][0][0] = tempCube[0][0][2];
                cube[4][0][1] = tempCube[0][1][2];
                cube[4][0][2] = tempCube[0][2][2];

                break;
                case 4:
                cube[1][0][0] = tempCube[0][0][0];
                cube[1][0][1] = tempCube[0][0][1];
                cube[1][0][2] = tempCube[0][0][2];

                cube[2][0][0] = tempCube[1][0][0];
                cube[2][0][1] = tempCube[1][0][1];
                cube[2][0][2] = tempCube[1][0][2];

                cube[3][0][0] = tempCube[2][0][0];
                cube[3][0][1] = tempCube[2][0][1];
                cube[3][0][2] = tempCube[2][0][2];
                
                cube[0][0][0] = tempCube[3][0][0];
                cube[0][0][1] = tempCube[3][0][1];
                cube[0][0][2] = tempCube[3][0][2];

                break;
                case 5:
                cube[0][2][0] = tempCube[1][2][0];
                cube[0][2][1] = tempCube[1][2][1];
                cube[0][2][2] = tempCube[1][2][2];

                cube[1][2][0] = tempCube[2][2][0];
                cube[1][2][1] = tempCube[2][2][1];
                cube[1][2][2] = tempCube[2][2][2];

                cube[2][2][0] = tempCube[3][2][0];
                cube[2][2][1] = tempCube[3][2][1];
                cube[2][2][2] = tempCube[3][2][2];
                
                cube[3][2][0] = tempCube[0][2][0];
                cube[3][2][1] = tempCube[0][2][1];
                cube[3][2][2] = tempCube[0][2][2];
                break;
            }
            }
        }

    
    }


    static void rotateFace(String[][] Face, boolean clockwise){

        String[][] tempFace = new String[3][3];

        for(int i=0; i<3;i++)
            for(int j=0; j<3;j++)
                tempFace[i][j] = Face[i][j];

        if(clockwise){
            //order is Face[y][x] or Face[row][col]
            int a;
            int b;
            for(int i=0; i<9;i++){
                a = i/3;
                b = 2;
                for(int j=0; j<3;j++){

                    Face[a][j] = tempFace[b][a];
                    b--;
                }
            }
            

            // Face[0][0] = tempFace[2][0];
            // Face[0][1] = tempFace[1][0];
            // Face[0][2] = tempFace[0][0];
            // Face[1][0] = tempFace[2][1];
            // Face[1][1] = tempFace[1][1];
            // Face[1][2] = tempFace[0][1];
            // Face[2][0] = tempFace[2][2];
            // Face[2][1] = tempFace[1][2];            
            // Face[2][2] = tempFace[0][2];
        }else{
            int a;
            int b;
            for(int i=0; i<9;i++){
                a = i/3;
                b = 2;
                for(int j=0; j<3;j++){

                    Face[b][a] = tempFace[a][j];
                    b--;
                }
            }
        }


    }


    public static void main(String[] args){
        
        inputf(Rcube);
    }
}

