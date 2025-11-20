package com.example.optionmenuexample;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_activity_layout);
            btnContext=findViewById(R.id.btnContext);
            btnPopup=findViewById(R.id.btnPopup);
//        showContextMenuFor(btnContext);
            registerForContextMenu(btnContext);
            btnPopup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popUp=new PopupMenu(MainActivity.this,v);
                    popUp.getMenuInflater().inflate(R.menu.my_option_menu,popUp.getMenu());
                    popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.menuRegister) {
                                showRegisterDialog();
                            } else if (item.getItemId() == R.id.menuExit) {
                                finishAffinity();
                            }
                            return false;
                        }

                    });
                    popUp.show();
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.my_option_menu, menu);
        }

        @Override
        public boolean onContextItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.menuRegister) {
                showRegisterDialog();
            } else if (item.getItemId() == R.id.menuExit) {
                finishAffinity();
            }
            return super.onContextItemSelected(item);
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.my_option_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == R.id.menuRegister) {
                Toast.makeText(this, "You clicked Register", Toast.LENGTH_SHORT).show();
                showRegisterDialog();   // Show dialog
                return true;

            } else if (item.getItemId() == R.id.menuExit) {
                finishAffinity(); // Close app
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


        public void showRegisterDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Registration Form");
            builder.setCancelable(false);

            LayoutInflater inflater = getLayoutInflater();
            View v = inflater.inflate(R.layout.registration_dialog_latout, null);

            Button btnSubmit = v.findViewById(R.id.btnSubmit);
            Button btnCancel = v.findViewById(R.id.btnCancel);

            builder.setView(v);

            AlertDialog dlg = builder.create();

            // Button listeners
            btnSubmit.setOnClickListener(view -> {
                Toast.makeText(MainActivity.this, "Submitted!", Toast.LENGTH_SHORT).show();
                dlg.dismiss();
            });

            btnCancel.setOnClickListener(view -> dlg.dismiss());

            dlg.show();
        }
    }