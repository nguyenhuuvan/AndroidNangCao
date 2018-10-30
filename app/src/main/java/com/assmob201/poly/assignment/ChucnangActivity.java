package com.assmob201.poly.assignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ChucnangActivity extends AppCompatActivity {
    private EditText edLink;
    private Button btnShareLink;
    private ImageView imgAvatar;
    private Button btnShareImage;

    ShareDialog shareDialog;
    ShareLinkContent shareLinkContent;
    public static int Select_Image = 1;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang);

        edLink = findViewById(R.id.edLink);
        btnShareLink = findViewById(R.id.btnShareLink);
        imgAvatar = findViewById(R.id.imgAvatar);
        btnShareImage = findViewById(R.id.btnShareImage);

        shareDialog = new ShareDialog(ChucnangActivity.this);
        btnShareLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shareDialog.canShow(ShareLinkContent.class)) {
                    shareLinkContent = new ShareLinkContent.Builder()
                            .setContentUrl(Uri.parse(edLink.getText().toString()))
                            .build();
                }
                shareDialog.show(shareLinkContent);
            }
        });

        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Select_Image);
            }
        });
        btnShareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                shareDialog.show(content);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Select_Image && resultCode == RESULT_OK) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(inputStream);
                imgAvatar.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
/*        if (requestCode == Select_Video && resultCode == RESULT_OK) {
            uriVideo = data.getData();
            video.setVideoURI(uriVideo);
        }*/
        super.onActivityResult(requestCode, resultCode, data);
    }
}
