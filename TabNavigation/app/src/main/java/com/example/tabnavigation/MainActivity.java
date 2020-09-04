package com.example.tabnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
   TabLayout tab;
   ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.mytablayout);
        viewPager=findViewById(R.id.myviewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
       tab.setupWithViewPager(viewPager);
       tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {

               Toast.makeText(MainActivity.this,
                       " Selected message"+tab.getText().toString(),
                       Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {
               Toast.makeText(MainActivity.this, " TabUnSelected message"+tab.getText().toString(), Toast.LENGTH_SHORT).show();


           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {
               Toast.makeText(MainActivity.this, " ReSelected message"+tab.getText().toString(), Toast.LENGTH_SHORT).show();


           }
       });
    }
    public class  MyPagerAdapter  extends FragmentPagerAdapter{
        //for giving tabs titles creating string array.
        String titles[]={"chats","calls","status"};

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new ChatsFragment();
            }
            if(position == 1){
                return new CallsFragment();
            }
            if(position == 2){
                return new StatusFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}