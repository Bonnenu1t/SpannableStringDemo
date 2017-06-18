package com.bawei.spannablestringdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

        String content = "我是要显示的内容";
        SpannableString spannableString = new SpannableString(content);
        //1...
        /*    //BackgroundColorSpan 背景色
        spannableString.setSpan(new BackgroundColorSpan(Color.BLUE),0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);*/

        //2...
         /*       //ForegroundColorSpan 前景色
        spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);*/

        //3...
       /*         //UnderlineSpan 下划线
        spannableString.setSpan(new UnderlineSpan(),0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);*/

       //4...
       /*         //ImageSpan  要显示的图片
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,50,50);
        spannableString.setSpan(new ImageSpan(drawable),2,4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);*/

       //5...
        /*        //StyleSpan 加粗 倾斜
        spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),0,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/

        //6...
        /*        //SubscriptSpan 下标
        spannableString.setSpan(new SubscriptSpan(),2,6, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);*/

        //7...
        /*        //SuperscriptSpan 上标
        spannableString.setSpan(new SuperscriptSpan(),2,6, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);*/

        //8...
        /*        //URLSpan 超文本 链接
        spannableString.setSpan(new URLSpan("http://www.baidu.com"),2,6, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        textView.setMovementMethod(new LinkMovementMethod());*/

        //9...
        //ClickableSpan 点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                System.out.println("onClick = " + widget);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.DKGRAY);
                ds.setUnderlineText(true);
            }
        };
        spannableString.setSpan(clickableSpan,2,6, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        //让URLSpan 可点击
        textView.setMovementMethod(new LinkMovementMethod());
    }

    /*public static SpannableString toImageSpan(Context context,String content,int[] emoIng,String[] emoText){

        SpannableString ss = new SpannableString(content);
        for (int i = 0; i < emoText.length; i++) {
            int startPos = 0 ;
            String rep = emoText[i];
            int fromPos = 0;
            while ((startPos = content.indexOf(rep, fromPos)) != -1) {
                fromPos = startPos + rep.length();

            }
            
        }

        return ss;
    }*/
}
