package com.luke.liangzhiying.ldemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.luke.liangzhiying.userlib.*;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "RBAC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RBAC rbac = RBAC.getInstance();
        User userA = rbac.addUser("Dan");
        Log.i(TAG,"add user "+userA.toString());
        User userB = rbac.addUser("Tom");
        Log.i(TAG,"add user "+userB.toString());
        Role r = rbac.addRole("Admin");
        Log.i(TAG,"add Role "+r.toString());
        WebPage webPageA = rbac.addWebPage("google.com");
        Log.i(TAG,"add WebPage "+webPageA.toString());
        rbac.assignRole(userA.getId(),r.getId());
        Log.i(TAG,"assign role");
        Log.i(TAG,"userA's role id is "+rbac.getUser(userA.getId()).getRoleId());
        Permissions p = rbac.assignPremission(webPageA.getId(),r.getId());
        Log.i(TAG,"assign Premission");
        Log.i(TAG,"UserA can access webPageA? "+rbac.canAccess(userA.getId(),webPageA.getId()));
        Log.i(TAG,"UserB can access webPageA? "+rbac.canAccess(userB.getId(),webPageA.getId()));
    }
}
