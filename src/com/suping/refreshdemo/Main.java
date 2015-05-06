package com.suping.refreshdemo;

import com.suping.refreshdemo.RefreshView.PullToRefreshListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity {
	RefreshView refreshableView;
	ListView listView;
	ArrayAdapter<String> adapter;
	String[] items = { "How will this benefit me?", "Join me, or die.", "For Lordaeron!", 
			"May my ancestors watch over me.", "You'd best stay clear of me, or I'll turn you into a mindless sheep.", "I stand ready.", "Sounds good.", 
			"We come in peace.", 
			"Every man lives, not every man truly dies", "After 10,000 years, our revenge is at hand", "ure sour is mine",
			"In the Lich King's name" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		refreshableView = (RefreshView) findViewById(R.id.refreshable_view);
		listView = (ListView) findViewById(R.id.list_view);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		listView.setAdapter(adapter);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshableView.finishRefreshing();
			}
		}, 0);
	}
}
