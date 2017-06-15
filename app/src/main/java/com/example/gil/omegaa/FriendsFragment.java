package com.example.gil.omegaa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FriendsFragment extends Fragment {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Friend> mFriends;
    FriendAdapter mAdapter;
    String TAG = getClass().getSimpleName();

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

        mFriends = new ArrayList<>();

        // specify an adapter (see also next example)
        mAdapter = new FriendAdapter(mFriends, getActivity());
        mRecyclerView.setAdapter(mAdapter);

         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("users");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue().toString();
                Log.d(TAG, "Value is: " + value);


                for(DataSnapshot dataSnapshot2 :dataSnapshot.getChildren()){


                    String value2 = dataSnapshot.getValue().toString();
                    Log.d(TAG, "Value is: " + value2);

                    Friend friend = dataSnapshot2.getValue(Friend.class);

                    // [START_EXCLUDE]
                    // Update RecyclerView
                    //mChats.add(dataSnapshot.getKey());
                    mFriends.add(friend);
                    mAdapter.notifyItemInserted(mFriends.size() - 1);
                    // [END_EXCLUDE]
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return v;
    }


}
