package edu.weber.cs.jacobgonzales.a2048;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameAreaFragment extends Fragment {

    private View root;
    private GestureDetectorCompat mDetector;
    private int randomBoxOne;
    private int randomBoxTwo;
    private int turnRandomBox;
    private int[] boxes = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int score;
    private int highscore = 0;
    private Random rand;
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnTen;
    private Button btnEleven;
    private Button btnTwelve;
    private Button btnThirteen;
    private Button btnFourteen;
    private Button btnFifteen;
    private Button btnScore;
    private Button btnHighscore;
    private Button btnMenu;
    private Button btnLeaderboard;
    private onButtonListener mCallBack;
    private boolean fullBoardChecker = false;
    private boolean gameWin = false;

    public interface onButtonListener{
        void menuButtonPressed();
        void leaderboardButtonPressed();
        void gameEnded();
        void gameWin();
    }

    public GameAreaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        try {
            mCallBack = (onButtonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " Must implement onButtonListener ");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return root = inflater.inflate(R.layout.fragment_game_area, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        //Generate New Game Boxes
        rand = new Random();
        while (randomBoxOne == randomBoxTwo)
        {
            randomBoxOne = rand.nextInt(16); //0-15
            randomBoxTwo = rand.nextInt(16); //0-15
        }

        btnZero = (Button) root.findViewById(R.id.btnZero);
        btnOne = (Button) root.findViewById(R.id.btnOne);
        btnTwo = (Button) root.findViewById(R.id.btnTwo);
        btnThree = (Button) root.findViewById(R.id.btnThree);
        btnFour = (Button) root.findViewById(R.id.btnFour);
        btnFive = (Button) root.findViewById(R.id.btnFive);
        btnSix = (Button) root.findViewById(R.id.btnSix);
        btnSeven = (Button) root.findViewById(R.id.btnSeven);
        btnEight = (Button) root.findViewById(R.id.btnEight);
        btnNine = (Button) root.findViewById(R.id.btnNine);
        btnTen = (Button) root.findViewById(R.id.btnTen);
        btnEleven = (Button) root.findViewById(R.id.btnEleven);
        btnTwelve = (Button) root.findViewById(R.id.btnTwelve);
        btnThirteen = (Button) root.findViewById(R.id.btnThirteen);
        btnFourteen = (Button) root.findViewById(R.id.btnFourteen);
        btnFifteen = (Button) root.findViewById(R.id.btnFifteen);
        btnScore = (Button) root.findViewById(R.id.score);
        btnHighscore = (Button) root.findViewById(R.id.highscore);

        btnMenu = (Button) root.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.menuButtonPressed();
            }
        });

        btnLeaderboard = (Button) root.findViewById(R.id.btnLeaderBoard);
        btnLeaderboard.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.leaderboardButtonPressed();
            }
        }));

        resetGameValues();
        newGameBoxes(randomBoxOne);
        newGameBoxes(randomBoxTwo);

    }

    public void newGameBoxes(int value){
        rand = new Random();
        int randomTwoOrFour = rand.nextInt(2); //0-1

        switch (value){
            case 0:
                if(randomTwoOrFour == 0){
                    btnZero.setText("2");
                    boxes[0] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnZero.setText("4");
                    boxes[0] = 4;
                }
                break;
            case 1:
                if(randomTwoOrFour == 0){
                    btnOne.setText("2");
                    boxes[1] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnOne.setText("4");
                    boxes[1] = 4;
                }
                break;
            case 2:
                if(randomTwoOrFour == 0){
                    btnTwo.setText("2");
                    boxes[2] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnTwo.setText("4");
                    boxes[2] = 4;
                }
                break;
            case 3:
                if(randomTwoOrFour == 0){
                    btnThree.setText("2");
                    boxes[3] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnThree.setText("4");
                    boxes[3] = 4;
                }
                break;
            case 4:
                if(randomTwoOrFour == 0){
                    btnFour.setText("2");
                    boxes[4] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnFour.setText("4");
                    boxes[4] = 4;
                }
                break;
            case 5:
                if(randomTwoOrFour == 0){
                    btnFive.setText("2");
                    boxes[5] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnFive.setText("4");
                    boxes[5] = 4;
                }
                break;
            case 6:
                if(randomTwoOrFour == 0){
                    btnSix.setText("2");
                    boxes[6] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnSix.setText("4");
                    boxes[6] = 4;
                }
                break;
            case 7:
                if(randomTwoOrFour == 0){
                    btnSeven.setText("2");
                    boxes[7] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnSeven.setText("4");
                    boxes[7] = 4;
                }
                break;
            case 8:
                if(randomTwoOrFour == 0){
                    btnEight.setText("2");
                    boxes[8] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnEight.setText("4");
                    boxes[8] = 4;
                }
                break;
            case 9:
                if(randomTwoOrFour == 0){
                    btnNine.setText("2");
                    boxes[9] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnNine.setText("4");
                    boxes[9] = 4;
                }
                break;
            case 10:
                if(randomTwoOrFour == 0){
                    btnTen.setText("2");
                    boxes[10] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnTen.setText("4");
                    boxes[10] = 4;
                }
                break;
            case 11:
                if(randomTwoOrFour == 0){
                    btnEleven.setText("2");
                    boxes[11] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnEleven.setText("4");
                    boxes[11] = 4;
                }
                break;
            case 12:
                if(randomTwoOrFour == 0){
                    btnTwelve.setText("2");
                    boxes[12] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnTwelve.setText("4");
                    boxes[12] = 4;
                }
                break;
            case 13:
                if(randomTwoOrFour == 0){
                    btnThirteen.setText("2");
                    boxes[13] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnThirteen.setText("4");
                    boxes[13] = 4;
                }
                break;
            case 14:
                if(randomTwoOrFour == 0){
                    btnFourteen.setText("2");
                    boxes[14] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnFourteen.setText("4");
                    boxes[14] = 4;
                }
                break;
            case 15:
                if(randomTwoOrFour == 0){
                    btnFifteen.setText("2");
                    boxes[15] = 2;
                }
                if(randomTwoOrFour == 1){
                    btnFifteen.setText("4");
                    boxes[15] = 4;
                }
                break;
        }
    }

    public void moveBoxesUp(){

        boolean moved = false;

        for(int i = 0; i <= 3; i++){
            int a = boxes[i];
            int b = boxes[i+4];
            int c = boxes[i+8];
            int d = boxes[i+12];


            if(a==0 && b==0 && c==0 && d==0){
                continue;
            }

            if(a>0 && b>0 && c>0 && d>0){
                if(a==b || b==c || c==d){

                }
                else{
                    continue;
                }
            }

            //Move all variables furthest top
            if(a==0){
                if(b>0){
                    a=b;
                    b=0;
                    moved = true;
                }
                if(c>0 && a==0){
                    a=c;
                    c=0;
                    moved = true;
                }
                if(d>0 && a==0){
                    a=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b==0){
                if(c>0){
                    b=c;
                    c=0;
                    moved = true;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b>0 && c==0){
                if(d>0){
                    c=d;
                    d=0;
                    moved = true;
                }
            }
            //Add Sames Together
            if(a>0 && a==b){
                a+=b;
                b=0;
                moved = true;
                score += a;
                if(b==0 && c>0){
                    b=c;
                    c=0;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                }
                if(c==0 && d>0){
                    c=d;
                    c=0;
                }
            }
            if(b>0 && b==c){
                b+=c;
                c=0;
                moved = true;
                score += b;
                if(c==0 && d>0){
                    c=d;
                    d=0;
                }
            }
            if(c>0 && c==d){
                c+=d;
                d=0;
                moved = true;
                score += c;
            }

            boxes[i] = a;
            boxes[i+4] = b;
            boxes[i+8] = c;
            boxes[i+12] = d;
        }

        if(moved == true){
            displayResults();
            addBox();
            btnScore.setText("Score\n" + score);
        }
    }
    public void moveBoxesRight(){

        boolean moved = false;

        for(int i = 3; i <= 15; i+=4){
            int a = boxes[i];
            int b = boxes[i-1];
            int c = boxes[i-2];
            int d = boxes[i-3];


            if(a==0 && b==0 && c==0 && d==0){
                continue;
            }

            if(a>0 && b>0 && c>0 && d>0){
                if(a==b || b==c || c==d){

                }
                else{
                    continue;
                }
            }

            //Move all variables furthest right
            if(a==0){
                if(b>0){
                    a=b;
                    b=0;
                    moved = true;
                }
                if(c>0 && a==0){
                    a=c;
                    c=0;
                    moved = true;
                }
                if(d>0 && a==0){
                    a=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b==0){
                if(c>0){
                    b=c;
                    c=0;
                    moved = true;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b>0 && c==0){
                if(d>0){
                    c=d;
                    d=0;
                    moved = true;
                }
            }
            //Add Sames Together
            if(a>0 && a==b){
                a+=b;
                b=0;
                moved = true;
                score += a;
                if(b==0 && c>0){
                    b=c;
                    c=0;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                }
                if(c==0 && d>0){
                    c=d;
                    c=0;
                }
            }
            if(b>0 && b==c){
                b+=c;
                c=0;
                moved = true;
                score += b;
                if(c==0 && d>0){
                    c=d;
                    d=0;
                }
            }
            if(c>0 && c==d){
                c+=d;
                d=0;
                moved = true;
                score += c;
            }

            boxes[i] = a;
            boxes[i-1] = b;
            boxes[i-2] = c;
            boxes[i-3] = d;
        }

        if(moved == true){
            displayResults();
            addBox();
            btnScore.setText("Score\n" + score);
        }
    }


    public void moveBoxesDown(){

        boolean moved = false;

        for(int i = 12; i <= 15; i++){
            int a = boxes[i];
            int b = boxes[i-4];
            int c = boxes[i-8];
            int d = boxes[i-12];


            if(a==0 && b==0 && c==0 && d==0){
                continue;
            }

            if(a>0 && b>0 && c>0 && d>0){
                if(a==b || b==c || c==d){

                }
                else{
                    continue;
                }
            }

            //Move all variables down
            if(a==0){
                if(b>0){
                    a=b;
                    b=0;
                    moved = true;
                }
                if(c>0 && a==0){
                    a=c;
                    c=0;
                    moved = true;
                }
                if(d>0 && a==0){
                    a=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b==0){
                if(c>0){
                    b=c;
                    c=0;
                    moved = true;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b>0 && c==0){
                if(d>0){
                    c=d;
                    d=0;
                    moved = true;
                }
            }
            //Add Sames Together
            if(a>0 && a==b){
                a+=b;
                b=0;
                moved = true;
                score += a;
                if(b==0 && c>0){
                    b=c;
                    c=0;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                }
                if(c==0 && d>0){
                    c=d;
                    c=0;
                }
            }
            if(b>0 && b==c){
                b+=c;
                c=0;
                moved = true;
                score += b;
                if(c==0 && d>0){
                    c=d;
                    d=0;
                }
            }
            if(c>0 && c==d){
                c+=d;
                d=0;
                moved = true;
                score += c;
            }

            boxes[i] = a;
            boxes[i-4] = b;
            boxes[i-8] = c;
            boxes[i-12] = d;
        }

        if(moved == true){
            displayResults();
            addBox();
            btnScore.setText("Score\n" + score);
        }
    }

    public void moveBoxesLeft(){

        boolean moved = false;

        for(int i = 0; i <= 12; i+=4){
            int a = boxes[i];
            int b = boxes[i+1];
            int c = boxes[i+2];
            int d = boxes[i+3];

            if(a==0 && b==0 && c==0 && d==0){
                continue;
            }

            if(a>0 && b>0 && c>0 && d>0){
                if(a==b || b==c || c==d){

                }
                else{
                    continue;
                }
            }

            //Move all variables down
            if(a==0){
                if(b>0){
                    a=b;
                    b=0;
                    moved = true;
                }
                if(c>0 && a==0){
                    a=c;
                    c=0;
                    moved = true;
                }
                if(d>0 && a==0){
                    a=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b==0){
                if(c>0){
                    b=c;
                    c=0;
                    moved = true;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                    moved = true;
                }
            }
            if(a>0 && b>0 && c==0){
                if(d>0){
                    c=d;
                    d=0;
                    moved = true;
                }
            }
            //Add Sames Together
            if(a>0 && a==b){
                a+=b;
                b=0;
                moved = true;
                score += a;
                if(b==0 && c>0){
                    b=c;
                    c=0;
                }
                if(b==0 && d>0){
                    b=d;
                    d=0;
                }
                if(c==0 && d>0){
                    c=d;
                    c=0;
                }
            }
            if(b>0 && b==c){
                b+=c;
                c=0;
                moved = true;
                score += b;
                if(c==0 && d>0){
                    c=d;
                    d=0;
                }
            }
            if(c>0 && c==d){
                c+=d;
                d=0;
                moved = true;
                score += c;
            }

            boxes[i] = a;
            boxes[i+1] = b;
            boxes[i+2] = c;
            boxes[i+3] = d;
        }

        if(moved == true){
            displayResults();
            addBox();
            btnScore.setText("Score\n" + score);
        }
    }

    public void addBox(){
        boolean isEmpty = true;
        boolean isEmptyTwo = true;
        boolean gameWinChecker = false;
        rand = new Random();



        for(int i = 0; i <= 15; i++){
            if (boxes[i] == 0){
                turnRandomBox = rand.nextInt(16); //0-15
                isEmpty = false;
                break;
            }

        }
        if (isEmpty == false) {
            while (boxes[turnRandomBox] != 0) {
                turnRandomBox = rand.nextInt(16); //0-15
            }
            newGameBoxes(turnRandomBox);
        }

        //Check if board is full
        for(int i = 0; i <= 15; i++){
            if (boxes[i] == 0){
                isEmptyTwo = false;
                break;
            }
        }

        if(isEmptyTwo == true){
            fullBoardChecker = true;
            checkBoard();
            if(fullBoardChecker == true){
                gameOver();
            }
        }

        //Check if user is a winner
        if(!gameWin){
            for(int i = 0; i < boxes.length; i++){
                if (boxes[i] == 2048){
                    gameWinChecker = true;
                    break;
                }
            }
        }

        if(gameWin == false){
            if(gameWinChecker){
                gameWin = true;
                mCallBack.gameWin();
            }
        }

    }

    public void checkBoard(){
        //Up Check
        for(int i = 0; i <= 3; i++) {
            int a = boxes[i];
            int b = boxes[i + 4];
            int c = boxes[i + 8];
            int d = boxes[i + 12];

            if(a == b || b == c || c == d){
                fullBoardChecker = false;
            }
        }

        //Right Check
        for(int i = 3; i <= 15; i+=4) {
            int a = boxes[i];
            int b = boxes[i - 1];
            int c = boxes[i - 2];
            int d = boxes[i - 3];

            if(a == b || b == c || c == d){
                fullBoardChecker = false;
            }
        }

        for(int i = 12; i <= 15; i++) {
            int a = boxes[i];
            int b = boxes[i - 4];
            int c = boxes[i - 8];
            int d = boxes[i - 12];

            if(a == b || b == c || c == d){
                fullBoardChecker = false;
            }
        }

        //Left Check
        for(int i = 0; i <= 12; i+=4){
            int a = boxes[i];
            int b = boxes[i+1];
            int c = boxes[i+2];
            int d = boxes[i+3];

            if(a == b || b == c || c == d){
                fullBoardChecker = false;
            }
        }

    }

    public void resetGameValues(){
        for(int i = 0; i < boxes.length; i++){
            boxes[i] = 0;
        }
        score = 0;
    }

    public void gameOver(){
        if(score > highscore){
            highscore = score;
            score = 0;
            btnHighscore.setText("Highscore\n" + highscore);
            btnScore.setText("Score\n" + score);
        }
        mCallBack.gameEnded();
    }

    public void newGame(){
        if(score > highscore){
            highscore = score;
            score = 0;
            btnHighscore.setText("Highscore\n" + highscore);
            btnScore.setText("Score\n" + score);
        }

        gameWin = false;

        //Generate New Game Boxes
        rand = new Random();
        do
        {
            randomBoxOne = rand.nextInt(16); //0-15
            randomBoxTwo = rand.nextInt(16); //0-15
        }while (randomBoxOne == randomBoxTwo);

        resetGameValues();
        displayResults();
        newGameBoxes(randomBoxOne);
        newGameBoxes(randomBoxTwo);
    }

    public void displayResults(){
        //Box 0
        if(boxes[0] > 0){
            btnZero.setText(boxes[0] + "");
        }
        else{
            btnZero.setText("");
        }

        //Box 1
        if(boxes[1] > 0){
            btnOne.setText(boxes[1] + "");

        }
        else{
            btnOne.setText("");
        }

        //Box 2
        if(boxes[2] > 0){
            btnTwo.setText(boxes[2] + "");
        }
        else{
            btnTwo.setText("");
        }

        //Box 3
        if(boxes[3] > 0){
            btnThree.setText(boxes[3] + "");
        }
        else{
            btnThree.setText("");

        }

        //Box 4
        if(boxes[4] > 0){
            btnFour.setText(boxes[4] + "");

        }
        else{
            btnFour.setText("");

        }

        //Box 5
        if(boxes[5] > 0){
            btnFive.setText(boxes[5] + "");

        }
        else{
            btnFive.setText("");

        }

        //Box 6
        if(boxes[6] > 0){
            btnSix.setText(boxes[6] + "");

        }
        else{
            btnSix.setText("");

        }

        //Box 7
        if(boxes[7] > 0){
            btnSeven.setText(boxes[7] + "");


        }
        else{
            btnSeven.setText("");

        }

        //Box 8
        if(boxes[8] > 0){
            btnEight.setText(boxes[8] + "");

        }
        else{
            btnEight.setText("");

        }

        //Box 9
        if(boxes[9] > 0){
            btnNine.setText(boxes[9] + "");
        }
        else{
            btnNine.setText("");
        }

        //Box 10
        if(boxes[10] > 0){
            btnTen.setText(boxes[10] + "");
        }
        else{
            btnTen.setText("");
        }

        //Box 11
        if(boxes[11] > 0){
            btnEleven.setText(boxes[11] + "");
        }
        else{

            btnEleven.setText("");
        }

        //Box 12
        if(boxes[12] > 0){
            btnTwelve.setText(boxes[12] + "");
        }
        else{
            btnTwelve.setText("");
        }

        //Box 13
        if(boxes[13] > 0){
            btnThirteen.setText(boxes[13] + "");
        }
        else{
            btnThirteen.setText("");
        }

        //Box 14
        if(boxes[14] > 0){
            btnFourteen.setText(boxes[14] + "");
        }
        else{
            btnFourteen.setText("");
        }

        //Box 15
        if(boxes[15] > 0){
            btnFifteen.setText(boxes[15] + "");
        }
        else{
            btnFifteen.setText("");
        }
    }
}
