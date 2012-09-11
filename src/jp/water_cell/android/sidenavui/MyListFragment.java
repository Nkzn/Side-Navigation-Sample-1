package jp.water_cell.android.sidenavui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MyListFragment extends ListFragment {

	String mType;

	ArrayList<String> mListItems;

	public static MyListFragment getInstance(String type, int max) {
		MyListFragment fragment = new MyListFragment();

		Bundle args = new Bundle();
		args.putString("type", type);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= max; i++) {
			list.add(type + i);
		}
		args.putStringArrayList(type, list);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle args = getArguments();
		mType = args.getString("type");
		mListItems = args.getStringArrayList(mType);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1);
		for (String s : mListItems) {
			adapter.add(s);
		}

		setListAdapter(adapter);

		// typeによって背景色を変える
		int bgColor = 0;
		if (TextUtils.equals(mType, "main")) {
			bgColor = android.R.color.background_light;
		} else if (TextUtils.equals(mType, "menu")) {
			bgColor = android.R.color.darker_gray;
		}

		getListView().setBackgroundColor(getResources().getColor(bgColor));
		getListView().setScrollingCacheEnabled(false);
	}
}
