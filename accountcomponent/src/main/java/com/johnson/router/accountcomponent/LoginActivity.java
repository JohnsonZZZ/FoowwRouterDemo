package com.johnson.router.accountcomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.johnson.router.facade.annotation.Autowired;
import com.johnson.router.facade.annotation.RouteNode;

@RouteNode(path = "/login", desc = "登录界面")
public class LoginActivity extends AppCompatActivity {


	@Autowired
	String bookName;

	@Autowired
	Author author;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

}

