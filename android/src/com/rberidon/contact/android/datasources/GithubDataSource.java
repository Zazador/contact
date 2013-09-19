package com.rberidon.contact.android.datasources;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.item.GitHubRepoItem;
import com.rberidon.contact.android.item.LinkItem;
import com.rberidon.contact.android.item.ListItem;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GitHubDataSource extends Data {
    public String username;
    public ArrayList<GitHubRepo> repos;
    public GitHub github;
    public Context context;
    public GitHubDataSource self;

    private final String seedData = "[{\"description\":\"Workflows for Alfred 2\",\"full_name\":\"rberidon/alfred-workflows\",\"name\":\"alfred-workflows\",\"id\":11896048},{\"description\":\"Android coding sample\",\"full_name\":\"rberidon/contact\",\"name\":\"contact\",\"id\":12859897},{\"description\":\"A collection of useful .gitignore templates\",\"full_name\":\"rberidon/gitignore\",\"name\":\"gitignore\",\"id\":12699791},{\"description\":\"iOS app created for UT Journalism School\\u0027s new mobile apps course\",\"full_name\":\"rberidon/PrixParty\",\"name\":\"PrixParty\",\"id\":12948978},{\"description\":\"Rayne\\u0027s common config files.\",\"full_name\":\"rberidon/rayneconfig\",\"name\":\"rayneconfig\",\"id\":4303831},{\"description\":\"Android util class for use in my projects\",\"full_name\":\"rberidon/Raynedroid\",\"name\":\"Raynedroid\",\"id\":11164014},{\"description\":\"wobsite\",\"full_name\":\"rberidon/rberidon.com\",\"name\":\"rberidon.com\",\"id\":12538511},{\"description\":\"Stat logging for OS X for interesting look at my computer\\u0027s history overtime\",\"full_name\":\"rberidon/Rstats\",\"name\":\"Rstats\",\"id\":4619627},{\"description\":\"Go to sleep :)\",\"full_name\":\"rberidon/sleeep\",\"name\":\"sleeep\",\"id\":12537511},{\"description\":\"Rayne\\u0027s music, better presented\",\"full_name\":\"rberidon/turbine\",\"name\":\"turbine\",\"id\":8201961}]";

    // Constants
    private static final String API_URL = "https://api.github.com";
    public static final String USER_URL = "http://www.github.com/%s";


    public static class GitHubRepo {
        public String name;
        public String full_name;
        public String description;
        public int id;
        public String login;
    }

    interface GitHub {
        @GET("/users/{owner}/repos")
        void repos(
                @Path("owner") String owner,
                Callback<List<GitHubRepo> > cb
        );
    }

    public GitHubDataSource(Context context, String username) {
        this.username = username;
        this.context = context;
        this.self = this;

        repos = new Gson().fromJson(seedData, new TypeToken<ArrayList<GitHubRepo> >(){}.getType());
        createList(repos);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setServer(API_URL)
                .build();
        github = restAdapter.create(GitHub.class);
        Callback populateRepoList = new Callback() {

            @Override
            public void success(Object o, Response response) {
                try {
                    Note.i("Github loaded for user " + self.getUsername());
                    ArrayList<GitHubRepo> repos = (ArrayList<GitHubRepo>) o;
                    self.createList(repos);
                    self.repos = repos;

                    Type listOfTestObject = new TypeToken<List<GitHubRepo> >(){}.getType();
                    String s = new Gson().toJson(repos, listOfTestObject);
                    Note.i("Serialized JSON (for creating new seedData): " + s);
                } catch (Exception e) {
                    Note.e("Error in decoding JSON response");
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Note.e("Retrofit error!");
                Note.e(".. Response: " + (retrofitError.getResponse() != null ? retrofitError.getResponse() : "(null)"));
                Note.e(".. Url: " + (retrofitError.getUrl() != null ? retrofitError.getUrl() : "(null)"));
            }
        };
        github.repos(username, populateRepoList);
    }

    public String getUsername() {
        return "@" + username;
    }
    public String getUserUrl() {
        return String.format(USER_URL, username);
    }

    private void createList(ArrayList<GitHubRepo> repos) {
        ArrayList<ListItem> gitHubListItems = new ArrayList<ListItem>();
        gitHubListItems.add(new LinkItem(self.context, "GitHub", self.getUsername(), self.getUserUrl()));
        for (GitHubRepo repo : repos) {
            Note.d("..Adding repo: " + repo.full_name);
            gitHubListItems.add(new GitHubRepoItem(self.context, repo));
        }
        ListManager.getInstance().addList(ListManager.GITHUB, gitHubListItems);
    }
}
