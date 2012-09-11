package jp.water_cell.android.sidenavui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.deaux.fan.FanView;

public class MainActivity extends FragmentActivity {

	FanView mFanView;

	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setHomeButtonEnabled(true);

		// 「mainN」な項目が並ぶListFragment
		MyListFragment mainFragment = MyListFragment.getInstance("main", 15); 
		// 「menuN」な項目が並ぶListFragment
		MyListFragment menuFragment = MyListFragment.getInstance("menu", 6);

		mFanView = (FanView) findViewById(R.id.fan_view);
		mFanView.setFragments(mainFragment, menuFragment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case android.R.id.home:
			mFanView.showMenu();
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
