package com.example.myapplication.Fragment;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialToolbar toolbar_home = view.findViewById(R.id.toolbar_home);
        TextView tv_home = view.findViewById(R.id.tv_home);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NotificationChannel channel = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel = new NotificationChannel("1", "channel 1", NotificationManager.IMPORTANCE_DEFAULT);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel.setDescription("This is channel 1");
            }
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
            notificationManagerCompat.createNotificationChannel(channel);


        }
        tv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "1")
                        .setSmallIcon(R.drawable.baseline_home_24)
                        .setContentTitle("Notification")
                        .setContentText("This is notification")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
                notificationManagerCompat.notify(1, builder.build());
            }
        });

        toolbar_home.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menu_item_sub1) {
                Toast.makeText(getContext(), "Sub 1", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.menu_item_sub2) {
                Toast.makeText(getContext(), "Sub 2", Toast.LENGTH_SHORT).show();
            }
            return false;
        });
    }


}
