package xyz.izen1231.angelhack;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

import xyz.izen1231.angelhack.pojo.Data;
import xyz.izen1231.angelhack.pojo.Data2;
import xyz.izen1231.angelhack.pojo.Data3;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    LinearLayout viewPager;
    FloatingActionButton fab1,fab2,fab3, fab4;
    private FloatingActionMenu fab;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.content_main_drawer);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
        setTitle("");

        fab=(FloatingActionMenu)findViewById(R.id.fab);
        fab1=(FloatingActionButton)findViewById(R.id.fab1);
        fab2=(FloatingActionButton)findViewById(R.id.fab2);
        fab3=(FloatingActionButton)findViewById(R.id.fab3);
        fab4=(FloatingActionButton)findViewById(R.id.fab4);

        viewPager=(LinearLayout) findViewById(R.id.viewPager);
        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fragment_c2c,viewPager,true);
        ArrayList<Data> data=new ArrayList<Data>();
        Data tmp=new Data();
        tmp.setWriter("asd");
        tmp.setDate("2018/6/17");
        tmp.setContent("hello world");
        tmp.setId("1");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("qjd");
        tmp.setDate("2018/6/17");
        tmp.setContent("hi");
        tmp.setId("2");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("qdqjd");
        tmp.setDate("2018/6/17");
        tmp.setContent("bye");
        tmp.setId("3");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("nncmm");
        tmp.setDate("2018/6/17");
        tmp.setContent("hi");
        tmp.setId("4");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("cnci");
        tmp.setDate("2018/6/17");
        tmp.setContent("what");
        tmp.setId("5");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("rrrww");
        tmp.setDate("2018/6/17");
        tmp.setContent("test");
        tmp.setId("6");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("w1ww");
        tmp.setDate("2018/6/17");
        tmp.setContent("test");
        tmp.setId("7");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("cbj2");
        tmp.setDate("2018/6/17");
        tmp.setContent("test");
        tmp.setId("8");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("kkkkw1");
        tmp.setDate("2018/6/17");
        tmp.setContent("test");
        tmp.setId("9");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("wdjnj3");
        tmp.setDate("2018/6/17");
        tmp.setContent("test");
        tmp.setId("10");
        data.add(tmp);

        tmp=new Data();
        tmp.setWriter("qwdkkk1");
        tmp.setDate("2018/6/17");
        tmp.setContent(".......");
        tmp.setId("11");
        data.add(tmp);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerAdapter mAdapter = new RecyclerAdapter(data);
        recyclerView.setAdapter(mAdapter);
//        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(viewPagerAdapter);
//        viewPager.setCurrentItem(0);
//
//        View.OnClickListener movePageListener = new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                int tag = (int) v.getTag();
//                if(viewPager.getCurrentItem()<2)
//                    viewPager.setCurrentItem(tag);
//            }
//        };

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                viewPager.removeAllViews();
                inflater.inflate(R.layout.fragment_tour,viewPager,true);
                ArrayList<Data2> data=new ArrayList<>();
                Data2 tmp=new Data2();
                tmp.setImgUri(String.valueOf(R.drawable.jp));
                tmp.setTourtext("일본");
                data.add(tmp);

                tmp=new Data2();
                tmp.setImgUri(String.valueOf(R.drawable.us));
                tmp.setTourtext("미국");
                data.add(tmp);

                tmp=new Data2();
                tmp.setImgUri(String.valueOf(R.drawable.uk));
                tmp.setTourtext("영국");
                data.add(tmp);

                tmp=new Data2();
                tmp.setImgUri(String.valueOf(R.drawable.ch));
                tmp.setTourtext("중국");
                data.add(tmp);

                tmp=new Data2();
                tmp.setImgUri(String.valueOf(R.drawable.ger));
                tmp.setTourtext("독일");
                data.add(tmp);

                tmp=new Data2();
                tmp.setImgUri(String.valueOf(R.drawable.swis));
                tmp.setTourtext("스위스");
                data.add(tmp);

                tmp=new Data2();
                tmp.setImgUri(String.valueOf(R.drawable.travel));
                tmp.setTourtext("베트남");
                data.add(tmp);

                RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView3);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(MainActivity.this, 2, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(mLayoutManager);
                RecyclerAdapter2 mAdapter = new RecyclerAdapter2(data);
                recyclerView.setAdapter(mAdapter);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                viewPager.removeAllViews();
                inflater.inflate(R.layout.score_fragment,viewPager,true);
                ArrayList<Data3> data = new ArrayList<Data3>();
                //ArrayList<Data3> data2 = new ArrayList<Data3>();

                Data3 tmp=new Data3();
                tmp=new Data3();
                tmp.setRank("#1");
                tmp.setScorename("hong gildong");
                data.add(tmp);
                tmp=new Data3();
                tmp.setRank("#2");
                tmp.setScorename("Aadan");
                data.add(tmp);
                tmp=new Data3();
                tmp.setRank("#3");
                tmp.setScorename("Steve");
                data.add(tmp);
                tmp=new Data3();
                tmp.setRank("#4");
                tmp.setScorename("김철수");
                data.add(tmp);
                tmp=new Data3();
                tmp.setRank("#5");
                tmp.setScorename("testname");
                data.add(tmp);

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fourth_recyclerView);
                //RecyclerView recyclerView1=(RecyclerView)findViewById(R.id.fourth_recyclerView2);
                recyclerView.setHasFixedSize(true);
                //recyclerView1.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(MainActivity.this, 1, LinearLayoutManager.VERTICAL, false);
                //RecyclerView.LayoutManager mLayoutManager2 = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(mLayoutManager);
                //recyclerView1.setLayoutManager(mLayoutManager2);
                RecyclerAdapter3 mAdapter = new RecyclerAdapter3(data);
                //RecyclerAdapter3_2 mAdapter2 = new RecyclerAdapter3_2(data);
                recyclerView.setAdapter(mAdapter);
                //recyclerView1.setAdapter(mAdapter2);

            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                viewPager.removeAllViews();
                inflater.inflate(R.layout.fragment_tip,viewPager,true);
//                startActivity(new Intent(MainActivity.this,FifthFragment.class));
//                fab.close(true);
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                viewPager.removeAllViews();
                inflater.inflate(R.layout.fragment_c2c,viewPager,true);
                ArrayList<Data> data=new ArrayList<Data>();
                Data tmp=new Data();
                tmp.setWriter("asd");
                tmp.setDate("2018/6/17");
                tmp.setContent("hello world");
                tmp.setId("1");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("qjd");
                tmp.setDate("2018/6/17");
                tmp.setContent("hi");
                tmp.setId("2");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("qdqjd");
                tmp.setDate("2018/6/17");
                tmp.setContent("bye");
                tmp.setId("3");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("nncmm");
                tmp.setDate("2018/6/17");
                tmp.setContent("hi");
                tmp.setId("4");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("cnci");
                tmp.setDate("2018/6/17");
                tmp.setContent("what");
                tmp.setId("5");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("rrrww");
                tmp.setDate("2018/6/17");
                tmp.setContent("test");
                tmp.setId("6");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("w1ww");
                tmp.setDate("2018/6/17");
                tmp.setContent("test");
                tmp.setId("7");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("cbj2");
                tmp.setDate("2018/6/17");
                tmp.setContent("test");
                tmp.setId("8");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("kkkkw1");
                tmp.setDate("2018/6/17");
                tmp.setContent("test");
                tmp.setId("9");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("wdjnj3");
                tmp.setDate("2018/6/17");
                tmp.setContent("test");
                tmp.setId("10");
                data.add(tmp);

                tmp=new Data();
                tmp.setWriter("qwdkkk1");
                tmp.setDate("2018/6/17");
                tmp.setContent(".......");
                tmp.setId("11");
                data.add(tmp);
                RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(MainActivity.this, 2, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(mLayoutManager);
                RecyclerAdapter mAdapter = new RecyclerAdapter(data);
                recyclerView.setAdapter(mAdapter);
//                startActivity(new Intent(MainActivity.this,FifthFragment.class));
//                fab.close(true);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;

            case 16908332:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.content_main_drawer) ;
                if (!drawer.isDrawerOpen(Gravity.LEFT)) { drawer.openDrawer(Gravity.LEFT) ; }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }
}
