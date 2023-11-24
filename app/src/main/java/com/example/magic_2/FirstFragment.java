package com.example.magic_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;


public class FirstFragment extends Fragment {

    private int life1 = 20;
    private int life2 = 20;
    private int poison1 = 0;
    private int poison2 = 0;
    private TextView counter1;
    private TextView counter2;

    public FirstFragment() {
    }

    public void inclife1(){
        life1++;
        updateViews();
    }
    public void inclife2(){
        life2++;
        updateViews();
    }
    public void declife1(){
        life1--;
        updateViews();
    }
    public void declife2(){
        life2--;
        updateViews();
    }
    public void incPoison1(){
        poison1++;
        updateViews();
    }
    public void incPoison2(){
        poison2++;
        updateViews();
    }
    public void decPoison1(){
        poison1--;
        updateViews();
    }
    public void decPoison2(){
        poison2--;
        updateViews();
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.fragment_first,container, false);

        ImageButton lifetwotoone = view.findViewById(R.id.lifetwotooone);
        ImageButton lifeonetootwo = view.findViewById(R.id.lifeonetootwo);
        Button p1poisonmore = view.findViewById(R.id.p1poisonmore);
        Button p1poisonless = view.findViewById(R.id.p1poisonless);
        Button p2poisonmore = view.findViewById(R.id.p2poisonmore);
        Button p2poisonless = view.findViewById(R.id.p2poisonless);
        ImageButton p1lifemore = view.findViewById(R.id.p1lifemore);
        ImageButton p2lifemore = view.findViewById(R.id.p2lifemore);
        ImageButton p2lifeless = view.findViewById(R.id.p2lifeless);
        ImageButton p1lifeless = view.findViewById(R.id.p1lifeless);
        counter1 = view.findViewById(R.id.counterp1);
        counter2 = view.findViewById(R.id.counterp2);

        if (savedInstanceState != null){
            life1 = savedInstanceState.getInt("life1");
            life2 = savedInstanceState.getInt("life2");
            poison1 = savedInstanceState.getInt("poison1");
            poison2 = savedInstanceState.getInt("poison2");

            updateViews();
        }

        View.OnClickListener listener = (View v) -> {
            if (v.getId() == R.id.lifeonetootwo) {
                declife2();
                inclife1();
            } else if (v.getId() == R.id.lifetwotooone) {
                declife1();
                inclife2();
            } else if (v.getId() == R.id.p1lifeless) {
                declife1();
            } else if (v.getId() == R.id.p1lifemore) {
                inclife1();
            } else if (v.getId() == R.id.p1poisonless) {
                decPoison1();
            } else if (v.getId() == R.id.p1poisonmore) {
                incPoison1();
            } else if (v.getId() == R.id.p2lifeless) {
                declife2();
            } else if (v.getId() == R.id.p2lifemore) {
                inclife2();
            } else if (v.getId() == R.id.p2poisonless) {
                decPoison2();
            } else if (v.getId() == R.id.p2poisonmore) {
                incPoison2();
            }
        };

        lifetwotoone.setOnClickListener(listener);
        lifeonetootwo.setOnClickListener(listener);
        p1poisonmore.setOnClickListener(listener);
        p1poisonless.setOnClickListener(listener);
        p2poisonmore.setOnClickListener(listener);
        p2poisonless.setOnClickListener(listener);
        p1lifemore.setOnClickListener(listener);
        p2lifemore.setOnClickListener(listener);
        p1lifeless.setOnClickListener(listener);
        p2lifeless.setOnClickListener(listener);

        updateViews();
        return view;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_reset, menu);
    }

    public void reset() {
        life1 = 20;
        life2 = 20;
        poison1 = 0;
        poison2 = 0;

        updateViews();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.reset) {
            reset();
            Snackbar.make(requireView(), "New Game!", Snackbar.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @SuppressLint("DefaultLocale")
    private void updateViews() {
        counter1.setText(String.format("%d/%d", life1, poison1));
        counter2.setText(String.format("%d/%d", life2, poison2));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("life1", life1);
        outState.putInt("life2", life2);
        outState.putInt("poison1",poison1);
        outState.putInt("poison2",poison2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        com.example.magic_2.databinding.FragmentFirstBinding binding = null;
    }

}