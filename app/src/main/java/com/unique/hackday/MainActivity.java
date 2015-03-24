package com.unique.hackday;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Choreographer;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.unique.hackday.adapter.MenuAdapter;
import com.unique.hackday.beans.EmojiBean;
import com.unique.hackday.fragment.AboutUsFragment;
import com.unique.hackday.utils.BaseUtils;
import com.unique.hackday.utils.BitmapUtil;
import com.unique.hackday.utils.DebugLog;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.my_toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.menu_list)
    ListView menuList;
    @InjectView(R.id.image_button_share)
    ImageButton shareButton;

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    RelativeLayout frameLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private int mPosition = 0;

    private boolean isSelected = false;
    private boolean isShare = true;

    final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.share");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        BaseUtils.setToolbar(mToolbar, this);
        shareButton.setVisibility(View.VISIBLE);
        init();
    }


    private void init() {
        frameLayout= (RelativeLayout) findViewById(R.id.content);



        final String[] fragments = getResources().getStringArray(R.array.fragment);


        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, Fragment.instantiate(MainActivity.this, fragments[0]));
        transaction.commit();

        menuList.setAdapter(new MenuAdapter(this));
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:
                        if (mPosition != position) {
                            mPosition = position;
                            isSelected = true;
                            isShare = true;
                        }

                        break;
                    case 1:
                        if (mPosition != position) {
                            mPosition = position;
                            isSelected = true;
                            isShare = false;
                        }
                        break;
                    case 2:
                        if (mPosition != position) {
                            mPosition = position;
                            isSelected = true;
                            isShare = false;
                        }
                        break;
                    case 3:
                        if (mPosition != position) {
                            mPosition = position;
                            isSelected = true;
                            isShare = false;
                        }
                        break;
                    default:
                        break;
                }
                mDrawerLayout.closeDrawer(Gravity.START);
                if (isShare) {
                    shareButton.setVisibility(View.VISIBLE);
                } else {
                    shareButton.setVisibility(View.GONE);
                }
            }
        });
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
                if (isSelected && 3 != mPosition) {

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.fragment_in, R.anim.fragment_out);
                    transaction.replace(R.id.content, Fragment.instantiate(MainActivity.this, fragments[mPosition]));
                    transaction.commit();
                }
                isSelected = false;
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                invalidateOptionsMenu();
            }

            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @OnClick(R.id.about_us_ll)
    void about() {
        if (mPosition != 3) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.fragment_in, R.anim.fragment_out);
            transaction.replace(R.id.content, new AboutUsFragment());
            transaction.commit();
            mPosition = 3;
            isShare = false;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @OnClick(R.id.image_button_share)
    void share() {


        //参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(this, "100424468",
                "c7394704798a158208a74ab60104f0ba");
        qqSsoHandler.addToSocialSDK();
        //参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.
        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(this, "100424468",
                "c7394704798a158208a74ab60104f0ba");
        qZoneSsoHandler.addToSocialSDK();
        // 设置分享图片，参数2为本地图片的资源引用
        String str=BitmapUtil.saveBitmap(BitmapMerge());
        if(!str.equals("")){
            mController.setShareMedia(new UMImage(this, str));
        }

        mController.openShare(this, false);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item);
    }

    public   Bitmap BitmapMerge(){
        if(frameLayout.getChildCount()==0){
            return null;
        }
        ArrayList<EmojiBean> emoji=new ArrayList<>();
        ArrayList<Integer> maxX=new ArrayList<>();
        ArrayList<Integer> maxY=new ArrayList<>();
        ArrayList<Integer> minX=new ArrayList<>();
        ArrayList<Integer> minY=new ArrayList<>();
        Bitmap bitmap;
        for(int i=0;i<frameLayout.getChildCount();i++){
            //TODO:Deal with ClassCastException
            ImageView iv=(ImageView)(((LinearLayout) frameLayout.getChildAt(i)).getChildAt(0));

            maxX.add((int) iv.getX() + iv.getWidth());
            maxY.add((int) iv.getY() + iv.getHeight());
            minX.add((int)iv.getX());
            minY.add((int)iv.getY());

            BitmapDrawable bd=(BitmapDrawable)iv.getDrawable();
            bitmap=bd.getBitmap();

            emoji.add(new EmojiBean((int)iv.getX(),(int)iv.getY(),iv.getWidth(),iv.getHeight(),bitmap));
        }
        Collections.sort(maxX);
        Collections.sort(maxY);
        Collections.sort(minX);
        Collections.sort(minY);
        Log.i("MinX", minX.get(0) + " " + maxX.get(maxX.size() - 1));
        Log.i("MinY",minY.get(0)+" "+maxY.get(maxY.size()-1));
        Log.i("Data",(maxX.get(maxX.size()-1)-minX.get(0))+" "+(maxY.get(maxY.size()-1)-minY.get(0)));

        Bitmap resbitmap=Bitmap.createBitmap(maxX.get(maxX.size()-1)-minX.get(0),maxY.get(maxY.size()-1)-minY.get(0), Bitmap.Config.ARGB_8888);
        return BitmapUtil.mixtureBitmap(BitmapUtil.createRGBImage(resbitmap, Color.WHITE), emoji, minX.get(0), minY.get(0));

    }


}
