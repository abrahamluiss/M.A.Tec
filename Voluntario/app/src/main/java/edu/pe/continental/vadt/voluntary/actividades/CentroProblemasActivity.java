package edu.pe.continental.vadt.voluntary.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.pe.continental.vadt.voluntary.R;
import edu.pe.continental.vadt.voluntary.fragments.HomeFragment;
import edu.pe.continental.vadt.voluntary.fragments.ProfileFragment;
import edu.pe.continental.vadt.voluntary.providers.AuthProvider;
import edu.pe.continental.vadt.voluntary.providers.UsersProvider;
import edu.pe.continental.vadt.voluntary.utils.ViewedMessageHelper;

public class CentroProblemasActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    //TokenProvider mTokenProvider;
    AuthProvider mAuthProvider;
    UsersProvider mUsersProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_problemas);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        //mTokenProvider = new TokenProvider();
        mAuthProvider = new AuthProvider();
        mUsersProvider = new UsersProvider();

        openFragment(new HomeFragment());
        //createToken();
    }


    @Override
    protected void onStart() {
        super.onStart();
        ViewedMessageHelper.updateOnline(true, CentroProblemasActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ViewedMessageHelper.updateOnline(false, CentroProblemasActivity.this);
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (item.getItemId() == R.id.itemHome) {
                        // FRAGMENT HOME
                        openFragment(new HomeFragment());
                    }
                    else if (item.getItemId() == R.id.itemBackMenu) {
                        // FRAGMENT MENU
                        Intent i = new Intent(CentroProblemasActivity.this, MenuActivity.class);
                        startActivity(i);
                    }

                    else if (item.getItemId() == R.id.itemProfile) {
                        // FRAGMENT PROFILE
                        openFragment(new ProfileFragment());
                    }
                    return true;
                }
            };

    // private void createToken() {
    //    mTokenProvider.create(mAuthProvider.getUid());
    //}
}