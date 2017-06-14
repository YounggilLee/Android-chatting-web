package com.example.gil.omegaa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FriendsFragment extends Fragment {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_friends, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rvFriend);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

       /* mChats = new ArrayList<>();

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(mChats, email, ChatActivity.this);
        mRecyclerView.setAdapter(mAdapter);*/

        return v;
    }


}
