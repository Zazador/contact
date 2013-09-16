package com.rberidon.contact.android.datasources;

import java.util.ArrayList;

public class Github {
    public String username;
    public ArrayList<GithubRepo> repos;

    // Constants
    public static final String API_REPOS_URL = "https://api.github.com/users/%s/repos";
    public static final String USER_URL = "http://www.github.com/%s";


    public Github(String username) {
        this.username = username;
        getRepos();
    }

    public String getUserUrl() {
        return String.format(USER_URL, username);
    }

    private void getRepos() {
        if (repos != null) {
            return;
        }

        /*
        String url = String.format(API_REPOS_URL, username);
        Note.d("Url: " + url);
        String response = JsonReader.readJsonFromUrl(url);
        Note.d("res: " + response);
        Gson g = new Gson();
        GithubRepo[] ghRepos = g.fromJson(response, GithubRepo[].class);
        repos = new ArrayList<GithubRepo>();
        if (ghRepos == null) {
            Note.e("Null repos!");
            return;
        }
        for (GithubRepo ghRepo : ghRepos) {
            repos.add(ghRepo);
            Note.i("Found Gh: " + ghRepo.name);
        }
        */
    }

}
