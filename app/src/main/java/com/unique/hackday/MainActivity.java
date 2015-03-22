package com.unique.hackday;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ImageReader;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.unique.hackday.adapter.MenuAdapter;
import com.unique.hackday.fragment.AboutUsFragment;
import com.unique.hackday.utils.BaseUtils;
import com.unique.hackday.utils.DebugLog;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {
    private int index=0;   //Id of Emoji
    @InjectView(R.id.my_toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.menu_list)
    ListView menuList;
    @InjectView(R.id.image_button_share)
    ImageButton shareButton;

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private RelativeLayout content;
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
        content= (RelativeLayout) findViewById(R.id.content);
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
    //TODO:addClickListener
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
        mController.setShareMedia(new UMImage(this, R.mipmap.share));
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


    private View createImage(Drawable drawable){
        ImageView iv = new ImageView(this);
        iv.setId(index++);
        iv.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        iv.setImageBitmap(bitmapDrawable.getBitmap());
        iv.setOnTouchListener(new View.OnTouchListener() {
            private float x,y;
            private int mx,my;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int screenWidth=content.getWidth();
                int screenHeight=content.getHeight();
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


}
