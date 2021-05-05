package edu.weber.cs.jacobgonzales.a2048;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private View root;
    private Button btnResumeGame;
    private Button btnNewGame;
    private Button btnLeaderboard;
    private onButtonListener mCallBack;

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button bt = (Button)v;
            if(bt.getId() == R.id.btnResumeGame){
                mCallBack.resumeButtonPressed();
            }
            if(bt.getId() == R.id.btnLeaderBoard){
                mCallBack.leaderButtonPressed();
            }
            if(bt.getId() == R.id.btnNewGame){
                mCallBack.newGameButtonPressed();
            }
        }
    };

    public interface onButtonListener{
        void resumeButtonPressed();
        void newGameButtonPressed();
        void leaderButtonPressed();
    }

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_menu, container, false);
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
    public void onResume() {
        super.onResume();
        btnResumeGame = (Button)root.findViewById(R.id.btnResumeGame);
        btnResumeGame.setOnClickListener(btnListener);

        btnNewGame = (Button)root.findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(btnListener);

        btnLeaderboard = (Button) root.findViewById(R.id.btnLeaderBoard);
        btnLeaderboard.setOnClickListener(btnListener);

    }
}
