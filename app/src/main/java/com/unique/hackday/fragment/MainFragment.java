package com.unique.hackday.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.unique.hackday.R;
import com.unique.hackday.utils.DebugLog;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainFragment extends Fragment implements View.OnClickListener {
//    class HeadViewHolder{
//        Context ctx;
//        ImageView head_one,head_two,head_three;
//        public HeadViewHolder(Context ctx){
//            this.ctx=ctx;
//        }
//
//    }
    ImageView head_one,head_two,head_three,brow_one,brow_two,brow_three,mouth_one,mouth_two,mouth_three,eye_one,eye_two,eye_three,up_one,up_two,up_three;

    View mainView;
    @InjectView(R.id.main_text_view_head)
    TextView headText;
    @InjectView(R.id.main_text_view_up)
    TextView upText;
    @InjectView(R.id.main_text_view_down)
    TextView downText;

    @InjectView(R.id.item_head)
    TextView itemHead;
    @InjectView(R.id.item_eye)
    TextView itemEye;
    @InjectView(R.id.item_mouth)
    TextView itemMouth;
    @InjectView(R.id.item_brow)
    TextView itemBrow;
    @InjectView(R.id.item_nose)
    TextView itemNose;
    @InjectView(R.id.item_other)
    TextView itemOther;

    @InjectView(R.id.main_body_ll)
    LinearLayout linearLayout;

    private boolean isHead = true;
    private boolean isUp = true;
    private boolean isItemHead = true;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, mainView);

        init(mainView);
        return mainView;

    }


    @Override
    public void onStart() {
        super.onStart();

    }

    public void init(View view) {

        head_one= (ImageView)mainView.findViewById(R.id.item_head_one);
        head_two=(ImageView)view.findViewById(R.id.item_head_two);
        head_three=(ImageView)view.findViewById(R.id.item_head_three);
        brow_one= (ImageView) view.findViewById(R.id.item_brow_one);
        brow_two= (ImageView)view.findViewById(R.id.item_brow_two);
        brow_three= (ImageView) view.findViewById(R.id.item_brow_three);
        mouth_one=(ImageView)view.findViewById(R.id.item_mouth_one);
        mouth_two=(ImageView)view.findViewById(R.id.item_mouth_two);
        mouth_three=(ImageView)view.findViewById(R.id.item_mouth_three);
        eye_one=(ImageView)view.findViewById(R.id.item_eye_one);
        eye_two=(ImageView)view.findViewById(R.id.item_eye_two);
        eye_three=(ImageView)view.findViewById(R.id.item_eye_three);
        up_one=(ImageView)view.findViewById(R.id.item_up_one);
        up_two=(ImageView)view.findViewById(R.id.item_up_two);
        up_three=(ImageView)view.findViewById(R.id.item_up_three);
        if(head_one!=null) {


            head_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((RelativeLayout) getActivity().findViewById(R.id.content)).addView(createImage(head_one.getBackground()));
                }
            });
        }
        if(head_two!=null){
            DebugLog.d("fun2");
            head_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(head_two.getBackground()));
                }
            });
        }
        if(head_three!=null){
            head_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(head_three.getBackground()));
                }
            });
        }
        if(brow_one!=null){
            brow_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(brow_one.getBackground()));
                }
            });
        }
        if(brow_three!=null){
            brow_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(brow_three.getBackground()));
                }
            });
        }
        if(brow_two!=null){
            brow_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(brow_two.getBackground()));
                }
            });
        }
        if(mouth_one!=null){
            mouth_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(mouth_one.getBackground()));
                }
            });

        }
        if(mouth_two!=null){
            mouth_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(mouth_two.getBackground()));
                }
            });

        }
        if(mouth_three!=null){
            mouth_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(mouth_three.getBackground()));
                }
            });

        }
        if(eye_one!=null){
            eye_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(eye_one.getBackground()));
                }
            });
        }
        if(eye_two!=null){
            eye_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(eye_two.getBackground()));
                }
            });
        }
        if(eye_three!=null){
            eye_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(eye_three.getBackground()));
                }
            });
        }
        if(up_one!=null){
            up_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(up_one.getBackground()));
                }
            });
        }
        if(up_two!=null){
            up_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(up_two.getBackground()));
                }
            });
        }
        if(up_three!=null){
            up_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(createImage(up_three.getBackground()));
                }
            });
        }
        headText.setOnClickListener(this);
        upText.setOnClickListener(this);
        downText.setOnClickListener(this);

        itemHead.setOnClickListener(this);
        itemMouth.setOnClickListener(this);
        itemNose.setOnClickListener(this);
        itemBrow.setOnClickListener(this);
        itemEye.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        
        final LayoutInflater inflaterTwo = LayoutInflater.from(getActivity());
        final LinearLayout picture = (LinearLayout) mainView.findViewById(R.id.picture_ll);
        int mpostion = 0;

        switch (v.getId()) {
            case R.id.main_text_view_head:

                cleanColor();
                mpostion = 1;
                isHead = true;
                headText.setBackgroundColor(Color.parseColor("#057464"));
                itemHead.setBackgroundColor(Color.parseColor("#057464"));
                LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(
                        R.layout.item_head, null);
                Log.i("Count", picture.getChildCount() + "");
                picture.removeAllViews();
                picture.addView(layout);
                head_one= (ImageView) mainView.findViewById(R.id.item_head_one);
                head_two=(ImageView)mainView.findViewById(R.id.item_head_two);
                head_three=(ImageView)mainView.findViewById(R.id.item_head_three);
                head_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ImageView imageView = createImage(head_one.getBackground()) ;
                        ((RelativeLayout) getActivity().findViewById(R.id.content)).addView(imageView);
                    }
                });
                if(head_two!=null){
                    DebugLog.d("fun2");
                    head_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(head_two.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                if(head_three!=null){
                    head_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(head_three.getBackground()) ;
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                break;
            case R.id.main_text_view_up:
                // do something when
                cleanColor();
                mpostion = 0;
                isHead = false;
                cleanChildColor();
                upText.setBackgroundColor(Color.parseColor("#057464"));
                layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(
                        R.layout.item_up, null);
                picture.removeAllViews();
                picture.addView(layout);
                up_one=(ImageView)mainView.findViewById(R.id.item_up_one);
                up_two=(ImageView)mainView.findViewById(R.id.item_up_two);
                up_three=(ImageView)mainView.findViewById(R.id.item_up_three);
                if(up_one!=null){
                    up_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(up_one.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                if(up_two!=null){
                    up_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(up_two.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                if(up_three!=null){
                    up_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(up_three.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                break;
            case R.id.main_text_view_down:
                cleanColor();
                //chose
                isHead = false;
                cleanChildColor();
                downText.setBackgroundColor(Color.parseColor("#057464"));
                break;
            case R.id.item_head:
                if (1 == mpostion || !isHead) {
                    break;
                }
                mpostion = 1;
                cleanChildColor();
                itemHead.setBackgroundColor(Color.parseColor("#057464"));
                layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(
                        R.layout.item_head, null);
                picture.removeAllViews();
                picture.addView(layout);
                break;
            case R.id.item_eye:
                if (3 == mpostion || !isHead) {
                    break;
                }
                mpostion = 3;
                cleanChildColor();
                itemEye.setBackgroundColor(Color.parseColor("#057464"));
                layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(
                        R.layout.item_eye, null);
                picture.removeAllViews();
                picture.addView(layout);
                eye_one=(ImageView)mainView.findViewById(R.id.item_eye_one);
                eye_two=(ImageView)mainView.findViewById(R.id.item_eye_two);
                eye_three=(ImageView)mainView.findViewById(R.id.item_eye_three);
                if(eye_one!=null){
                    eye_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(eye_one.getBackground()) ;
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                if(eye_two!=null){
                    eye_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(eye_two.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                if(eye_three!=null){
                    eye_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(eye_three.getBackground()) ;
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                break;
            case R.id.item_brow:
                if (2 == mpostion || !isHead) {
                    break;
                }
                mpostion = 2;
                cleanChildColor();
                itemBrow.setBackgroundColor(Color.parseColor("#057464"));
                layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(
                        R.layout.item_brow, null);
                picture.removeAllViews();
                picture.addView(layout);
                brow_one= (ImageView) mainView.findViewById(R.id.item_brow_one);
                brow_two= (ImageView)mainView.findViewById(R.id.item_brow_two);
                brow_three= (ImageView) mainView.findViewById(R.id.item_brow_three);
                if(brow_one!=null){
                    brow_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(brow_one.getBackground()) ;
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                if(brow_three!=null){
                    brow_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(brow_three.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                if(brow_two!=null){
                    brow_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(brow_two.getBackground()) ;
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });
                }
                break;
            case R.id.item_nose:
                if (4 == mpostion || !isHead) {
                    break;
                }
                mpostion = 4;
                cleanChildColor();
                itemNose.setBackgroundColor(Color.parseColor("#057464"));
                break;
            case R.id.item_mouth:
                if (5 == mpostion || !isHead) {
                    break;
                }
                mpostion = 5;
                cleanChildColor();
                itemMouth.setBackgroundColor(Color.parseColor("#057464"));
                layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(
                        R.layout.item_mouth, null);
                picture.removeAllViews();
                picture.addView(layout);
                mouth_one=(ImageView)mainView.findViewById(R.id.item_mouth_one);
                mouth_two=(ImageView)mainView.findViewById(R.id.item_mouth_two);
                mouth_three=(ImageView)mainView.findViewById(R.id.item_mouth_three);
                if(mouth_one!=null){
                    mouth_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView = createImage(mouth_one.getBackground()) ;
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });

                }
                if(mouth_two!=null){
                    mouth_two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView=createImage(mouth_two.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });

                }
                if(mouth_three!=null){
                    mouth_three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageView imageView=createImage(mouth_three.getBackground());
                            ((RelativeLayout)getActivity().findViewById(R.id.content)).addView(imageView);
                        }
                    });

                }

                break;
            default:
                break;
        }

    }
    private ImageView createImage(Drawable drawable){
        ImageView iv = new ImageView(getActivity());
        iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        iv.setImageBitmap(bitmapDrawable.getBitmap());
        iv.setOnTouchListener(new View.OnTouchListener() {
            private float x,y;
            private int mx,my;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int screenWidth=getActivity().findViewById(R.id.content).getWidth();
                int screenHeight=getActivity().findViewById(R.id.content).getHeight();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = event.getRawX();
                        y = event.getRawY();
                    case MotionEvent.ACTION_MOVE:
                        mx = (int) (event.getRawX() - x );
                        my = (int) (event.getRawY() - y );
                        int l=v.getLeft()+mx;
                        int b=v.getBottom()+my;
                        int r=v.getRight()+mx;
                        int t=v.getTop()+my;
                        if(l<0){
                            l=0;
                            r=l+v.getWidth();
                        }
                        if(t<0){
                            t=0;
                            b=t+v.getHeight();

                        }
                        if(r>screenWidth){
                            r=screenWidth;
                            l=r-v.getWidth();
                        }
                        if(b>screenHeight){
                            b=screenHeight;
                            t=b-v.getHeight();
                        }

                        v.layout(l,t,r,b);
                        x=(int)event.getRawX();
                        y=(int)event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.postInvalidate();
                }

                return true;
            }
        });
        return iv;
    }
    public void cleanColor() {

        headText.setBackgroundColor(Color.parseColor("#089d87"));
        upText.setBackgroundColor(Color.parseColor("#089d87"));
        downText.setBackgroundColor(Color.parseColor("#089d87"));

    }

    public void cleanChildColor() {
        itemHead.setBackgroundColor(Color.parseColor("#089d87"));
        itemEye.setBackgroundColor(Color.parseColor("#089d87"));
        itemBrow.setBackgroundColor(Color.parseColor("#089d87"));
        itemNose.setBackgroundColor(Color.parseColor("#089d87"));
        itemMouth.setBackgroundColor(Color.parseColor("#089d87"));

    }

    public void itemHead() {

    }

}
