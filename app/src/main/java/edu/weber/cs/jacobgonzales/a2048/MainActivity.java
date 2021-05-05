package edu.weber.cs.jacobgonzales.a2048;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
                                                                GameAreaFragment.onButtonListener,
                                                                MenuFragment.onButtonListener,
                                                                GameOverDialogFragment.dialogListener,
                                                                GameWinDialogFragment.dialogListener{

    private FragmentManager fm;
    private GameAreaFragment fragmentGameArea;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.mainFragment, new GameAreaFragment(), "GameAreaFragment")
                .commit();

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        final int SWIPE_THRESHOLD = 100;
        final int SWIPE_VELOCITY_THRESHOLD = 100;
        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                    result = true;
                }
            }
            else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    onSwipeBottom();
                } else {
                    onSwipeTop();
                }
                result = true;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }
    void onSwipeTop() {
        if (fragmentGameArea == null){
            FragmentManager fm = getSupportFragmentManager();
            fragmentGameArea = (GameAreaFragment) fm.findFragmentById(R.id.mainFragment);
        }
        fragmentGameArea.moveBoxesUp();
    }
    void onSwipeRight() {
        if (fragmentGameArea == null){
            FragmentManager fm = getSupportFragmentManager();
            fragmentGameArea = (GameAreaFragment) fm.findFragmentById(R.id.mainFragment);
        }
        fragmentGameArea.moveBoxesRight();
    }
    void onSwipeBottom() {
        if (fragmentGameArea == null){
            FragmentManager fm = getSupportFragmentManager();
            fragmentGameArea = (GameAreaFragment) fm.findFragmentById(R.id.mainFragment);
        }
        fragmentGameArea.moveBoxesDown();
    }
    void onSwipeLeft() {
        if (fragmentGameArea == null){
            FragmentManager fm = getSupportFragmentManager();
            fragmentGameArea = (GameAreaFragment) fm.findFragmentById(R.id.mainFragment);
        }
        fragmentGameArea.moveBoxesLeft();
    }

    //Game Buttons
    @Override
    public void menuButtonPressed() {
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.mainFragment, new MenuFragment(), "MenuFragment")
                .commit();
    }

    @Override
    public void leaderboardButtonPressed() {

    }

    @Override
    public void gameEnded(){
        GameOverDialogFragment dialog = new GameOverDialogFragment();
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), "confirm_dialog");
    }

    @Override
    public void gameWin(){
        GameWinDialogFragment dialog = new GameWinDialogFragment();
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), "confirm_dialog");
    }

    //Menu Buttons
    @Override
    public void resumeButtonPressed() {
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.mainFragment, new GameAreaFragment(), "GameAreaFragment")
                .commit();
    }

    @Override
    public void newGameButtonPressed() {
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.mainFragment, new GameAreaFragment(), "GameAreaFragment")
                .commit();
    }

    @Override
    public void leaderButtonPressed() {

    }


    @Override
    public void confirm() {
        if (fragmentGameArea == null){
            FragmentManager fm = getSupportFragmentManager();
            fragmentGameArea = (GameAreaFragment) fm.findFragmentById(R.id.mainFragment);
        }
        fragmentGameArea.newGame();

    }

    @Override
    public void confirmWin() {
    }

    @Override
    public void confirmNewGame() {
        if (fragmentGameArea == null){
            FragmentManager fm = getSupportFragmentManager();
            fragmentGameArea = (GameAreaFragment) fm.findFragmentById(R.id.mainFragment);
        }
        fragmentGameArea.newGame();
    }
}
