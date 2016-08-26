package com.example.sachingupta.test3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

/**
 * Created by SACHIN GUPTA on 8/14/2016.
 */
public class PrimaryFragment extends Fragment {
    public PrimaryFragment() {
        // Required empty public constructor
    }

    Animation animFadein;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V=inflater.inflate(R.layout.item_select_ip,container,false);
        ImageView imageView1= (ImageView) V.findViewById(R.id.pic1);
        ImageView imageView2= (ImageView) V.findViewById(R.id.pic2);
        ImageView imageView3= (ImageView) V.findViewById(R.id.pic3);
        ImageView imageVie4= (ImageView) V.findViewById(R.id.pic4);
        ImageView imageView5= (ImageView) V.findViewById(R.id.pic5);
        ViewFlipper viewFlipper = (ViewFlipper) V.findViewById(R.id.bckgrndViewFlipper1);
        LinearLayout exampaper= (LinearLayout) V.findViewById(R.id.exampaper);
        animFadein = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                R.anim.fade_in);
        exampaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),DisplayMessageActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });


        animFadein.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



        Animation animFadeout = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                R.anim.fade_out);
        animFadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        viewFlipper.setInAnimation(animFadein);
        viewFlipper.setOutAnimation(animFadeout);
//sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();

        return V;
    }

}

