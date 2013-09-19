package com.rberidon.contact.android.datasources;

import android.R;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import com.google.gson.Gson;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.item.GithubRepoItem;
import com.rberidon.contact.android.item.LinkItem;
import com.rberidon.contact.android.list.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Github extends Data {
    public String username;
    public ArrayList<GithubRepo> repos;
    private Github self;

    // Constants
    public static final String API_REPOS_URL = "https://api.github.com/users/%s/repos";
    public static final String USER_URL = "http://www.github.com/%s";


    public Github(String username) {
        this.username = username;
        repos = new ArrayList<GithubRepo>();
        self = this;
        new GetGithubReposTask().execute(this);
    }

    public String getUserUrl() {
        return String.format(USER_URL, username);
    }

    public String getApiReposUrl() {
        return String.format(API_REPOS_URL, username);
    }

    public List getList(Context context) {
        List l = new List("Github");
        if (repos != null) {
            l.addItem(new LinkItem("Github", "@rberidon", "http://www.github.com/rberidon"));
            for (GithubRepo repo : repos) {
                l.addItem(new GithubRepoItem(context, repo));
            }
        }

        return l;
    }

    private class GetGithubReposTask extends AsyncTask<Github, Void, ArrayList<GithubRepo>> {
        protected ArrayList<GithubRepo> doInBackground(Github... ghInput) {
            Github userGh = ghInput[0];

            ArrayList <GithubRepo> output = new ArrayList<GithubRepo>();

            String url = userGh.getApiReposUrl();
            Note.d("Github user url: " + url);
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            Note.d("http: " + httppost.getURI());
            Note.d("http: " + httppost.getParams().toString());
            Note.d("http: " + httppost.getAllHeaders().toString());
            httppost.setHeader("Content-type", "application/json");

            InputStream inputStream = null;
            String result = null;
            try {
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();

                inputStream = entity.getContent();
                // json is UTF-8 by default
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    Note.v("Line: " + line);
                    sb.append(line + "\n");
                }
                result = sb.toString();
                Note.d("Returned Github request was: " + result);
            } catch (Exception e) {
                // Oops
                Note.e("Exception reading Github: ");
                e.printStackTrace();
            }
            finally {
                try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
            }

            try {
                GithubRepo[] ghRepos = new Gson().fromJson(result, GithubRepo[].class);
                for (GithubRepo ghRepo : ghRepos) {
                    Note.i(".. found repo: " + ghRepo.name);
                    repos.add(ghRepo);
                }
            } catch (Exception e) {
                Note.e("Unable to get Github info from url: " + url);
                return null;
            }
            return repos;
        }

        protected void onPostExecute(ArrayList<GithubRepo> repos) {
            self.repos = repos;
        }
    }


}
