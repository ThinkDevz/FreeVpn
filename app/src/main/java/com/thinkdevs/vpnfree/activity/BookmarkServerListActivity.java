package com.thinkdevs.vpnfree.activity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.thinkdevs.vpnfree.R;
import com.thinkdevs.vpnfree.adapter.BookmarkServerListAdapter;
import com.thinkdevs.vpnfree.model.Server;

import java.util.List;

public class BookmarkServerListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_server_list);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-8831705983843599/3875324154");
// TODO: Add adView to your view hierarchy.
    }

    @Override
    protected void onResume() {
        super.onResume();
        final List<Server> serverList = dbHelper.getBookmarks();
        BookmarkServerListAdapter adapter = new BookmarkServerListAdapter(serverList, this, dbHelper);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bookmarkRv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }
}
