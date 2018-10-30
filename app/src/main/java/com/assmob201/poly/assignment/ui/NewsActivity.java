package com.assmob201.poly.assignment.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.adapter.AdapterNews;
import com.assmob201.poly.assignment.model.News;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.assmob201.poly.assignment.R;

public class NewsActivity extends AppCompatActivity {
    AdapterNews adapterNews;
    LinearLayoutManager layoutManager;
    RecyclerView lvListNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvListNews = findViewById(R.id.lvListnews);
        checkInternet();
    }
    public void checkInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifi = networkInfo.isConnected();
        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobile = networkInfo.isConnected();
       if(isMobile ||isWifi){
           LoadRssFromInternetTask loadRssFromInternetTask = new LoadRssFromInternetTask(NewsActivity.this);
           loadRssFromInternetTask.execute("http://vietnamnet.vn/rss/giao-duc.rss");
       }else{
           Toast.makeText(this, "Chưa bật kết nối mạng", Toast.LENGTH_SHORT).show();
       }
    }
    class LoadRssFromInternetTask extends AsyncTask<String, Long, List<News>> {


        private Context context;

        public LoadRssFromInternetTask(Context context) {
            this.context = context;

        }

        @Override
        protected List<News> doInBackground(String... strings) {


            ArrayList<News> newsArrayList = new ArrayList();

            try {
                URL url = new URL(strings[0]);

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(getInputStream(url), "UTF_8");

                int eventType = xpp.getEventType();
                String text = "";

                News news = null;
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String nameTag = xpp.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:

                            if (nameTag.equalsIgnoreCase("item")) {
                                news = new News();

                            }
                            break;
                        case XmlPullParser.TEXT:
                            text = xpp.getText();
                            break;
                        case XmlPullParser.END_TAG:
                            if (nameTag.equals("item"))
                                newsArrayList.add(news);
                            else if (news != null & nameTag.equalsIgnoreCase("title"))
                                news.title = text.trim();
                            else if (news != null & nameTag.equalsIgnoreCase("link"))
                                news.link = text.trim();
                            else if (news != null & nameTag.equalsIgnoreCase("pubDate"))
                                news.pubDate = text.trim();
                            else if (news!=null & nameTag.equalsIgnoreCase("description"))
                                news.description = text.trim();
                            else if (news!=null & nameTag.equalsIgnoreCase("image"))
                                news.image = text.trim();
                            break;
                        default:
                            break;

                    }

                    eventType = xpp.next();
                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return newsArrayList;
        }

        private InputStream getInputStream(URL url) {
            try {
                return url.openConnection().getInputStream();
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<News> news) {
            super.onPostExecute(news);

            adapterNews = new AdapterNews(context, news);
            layoutManager = new LinearLayoutManager(context);
            lvListNews.setLayoutManager(layoutManager);
            lvListNews.setAdapter(adapterNews);

        }
    }
}
