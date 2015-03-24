package com.unique.hackday.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.unique.hackday.beans.EmojiBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2015/3/22.
 */
public class BitmapUtil {
    public static String saveBitmap(Bitmap drawingCache){
        FileOutputStream fos=null;
        String picPath=null;
        try{
            String sdpath= Environment.getExternalStorageDirectory().getCanonicalPath();

            File f=new File(sdpath,System.currentTimeMillis()+".png");
            Log.i("Path", sdpath + "" + System.currentTimeMillis() + ".png");
            if(f.exists()){
                f.delete();
            }
            fos=new FileOutputStream(f);
            if(null!=fos){
                drawingCache.compress(Bitmap.CompressFormat.PNG,100,fos);
                fos.flush();
                fos.close();
            }

            return f.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static Bitmap createRGBImage(Bitmap bitmap,int color){
        int bitmap_w=bitmap.getWidth();
        int bitmap_h=bitmap.getHeight();
        int[] arrayColor=new int[bitmap_w*bitmap_h];
        int count=0;
        for(int i=0;i<bitmap_h;i++){
            for(int j=0;j<bitmap_w;j++){
                int color1=bitmap.getPixel(j,i);
                if(color1!=0){

                }else{
                    color1=color;
                }
                arrayColor[count]=color;
                count++;
            }
        }
        bitmap = Bitmap.createBitmap( arrayColor, bitmap_w, bitmap_h, Bitmap.Config.ARGB_8888 ).copy(Bitmap.Config.ARGB_8888,true);
        return bitmap;
    }
    public static Bitmap mixtureBitmap(Bitmap bitmap,ArrayList<EmojiBean> emojiBeanArrayList,int minX,int minY){
        Canvas cv=new Canvas(bitmap);

        Paint paint=new Paint();
        ColorMatrix colorMatrix=new ColorMatrix();
        float[] colorArray={1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0};
        colorMatrix.setSaturation(0);
//        colorMatrix.set(colorArray);
        ColorMatrixColorFilter colorMatrixColorFilter=new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);

        cv.drawBitmap(bitmap,0,0,paint);
        for(int i=0;i<emojiBeanArrayList.size();i++){

            cv.drawBitmap(emojiBeanArrayList.get(i).getBitmap(),emojiBeanArrayList.get(i).getX()-minX,emojiBeanArrayList.get(i).getY()-minY,null);
            Log.i("bitmapwidth", bitmap.getWidth() + "");
            Log.i("bitmapheight",bitmap.getHeight()+"");
            Log.i("X",emojiBeanArrayList.get(i).getX()+"");
            Log.i("Y",emojiBeanArrayList.get(i).getY()+"");
            Log.i("Pic", (emojiBeanArrayList.get(i).getX()-bitmap.getWidth() ) + "  " + (emojiBeanArrayList.get(i).getY() - bitmap.getHeight()) + "");
        }
        cv.save(Canvas.ALL_SAVE_FLAG);
        cv.restore();
        return createRGBImage(bitmap, Color.WHITE);
    }
    public  static Bitmap   BitmapMerge(ViewGroup viewGroup){
        if(viewGroup.getChildCount()==0){
            return null;
        }
        ArrayList<EmojiBean> emoji=new ArrayList<>();
        ArrayList<Integer> maxX=new ArrayList<>();
        ArrayList<Integer> maxY=new ArrayList<>();
        ArrayList<Integer> minX=new ArrayList<>();
        ArrayList<Integer> minY=new ArrayList<>();
        Bitmap bitmap;
        for(int i=0;i<viewGroup.getChildCount();i++){
            ImageView iv=(ImageView)(viewGroup.getChildAt(i));

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
        Log.i("MinX",minX.get(0)+" "+maxX.get(maxX.size()-1));
        Log.i("MinY",minY.get(0)+" "+maxY.get(maxY.size()-1));
        Log.i("Data",(maxX.get(maxX.size()-1)-minX.get(0))+" "+(maxY.get(maxY.size()-1)-minY.get(0)));

        Bitmap resbitmap=Bitmap.createBitmap(maxX.get(maxX.size()-1)-minX.get(0),maxY.get(maxY.size()-1)-minY.get(0), Bitmap.Config.ARGB_8888);
        return mixtureBitmap(createRGBImage(resbitmap, Color.WHITE),emoji,minX.get(0),minY.get(0));

    }

}
