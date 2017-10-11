package ke.co.interintel.interapp.interintelapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ke.co.interintel.interapp.interintelapp.component.SessionManager;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.fab_myPosition)
    FloatingActionButton fabMyPosition;
    @BindView(R.id.fab_view)
    FloatingActionButton fabView;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.edit_placeName)
    AutoCompleteTextView editPlaceName;
    @BindView(R.id.btn_menu)
    ImageView btnMenu;
    @BindView(R.id.call_btn)
    ImageView callBtn;

    SessionManager sessionManager;
    final static int REQUEST_LOCATION = 199;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sessionManager = new SessionManager(this);
        sessionManager = new SessionManager(this);

        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setUpNavigationView();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something you want
                appBar.setExpanded(true);
            }
        });


        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();

        AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(AppBarLayout appBarLayout) {
                return false;
                //  return true;
            }
        });
        params.setBehavior(behavior);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                sessionManager.logoutUser();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                                                         // This method will trigger on item Click of navigation menu
                                                         @Override
                                                         public boolean onNavigationItemSelected(MenuItem menuItem) {

                                                             //Check to see which item was being clicked and perform appropriate action
                                                             switch (menuItem.getItemId()) {
                                                                 //Replacing the main content with ContentFragment Which is our Inbox View;
                                                                 case R.id.nav_map:

                                                                     break;
                                                                 case R.id.nav_settings:

                                                                     break;
                                                                 case R.id.nav_privacy_policy:

                                                                     break;
                                                             }

                                                             //Checking if the item is in checked state or not, if not make it in checked state
                                                             if (menuItem.isChecked()) {
                                                                 menuItem.setChecked(false);
                                                             } else {
                                                                 menuItem.setChecked(true);
                                                             }
                                                             menuItem.setChecked(true);


                                                             return true;
                                                         }
                                                     }
        );
    }


    public void collapseToolbar() {
        appBar.setExpanded(false);
    }

    @Override
    public void onBackPressed() {
        //Include the code here
        appBar.setExpanded(true);
        return;
    }

    @OnClick(R.id.fab_view)
    public void onClick() {
        collapseToolbar();
    }


    @OnClick(R.id.btn_menu)
    public void onViewClicked() {
        drawerLayout.openDrawer(Gravity.LEFT);
    }



    @OnClick(R.id.call_btn)
    public void onViewClicked2() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "0701064273"));
        startActivity(intent);
    }

    @OnClick(R.id.fab_myPosition)
    public void onViewClicked3() {
        sessionManager.logoutUser();
        finish();

    }
}
