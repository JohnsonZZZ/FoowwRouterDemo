package com.johnson.router.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.johnson.component.componentlib.router.Router;
import com.johnson.component.componentlib.router.ui.UIRouter;
import com.johnson.component.componentlib.service.JsonService;
import com.johnson.router.facade.annotation.RouteNode;

@RouteNode(path = "/main", desc = "主界面")
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

	private static final Integer REQUEST_CODE = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIRouter.getInstance().registerUI("app");
		findViewById(R.id.btn).setOnClickListener(this);
		findViewById(R.id.btn_register).setOnClickListener(this);
		findViewById(R.id.btn_unregister).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn:
				goToShareActivityWithBundle();
				break;
			case R.id.btn_register:
				Router.registerComponent("com.johnson.router.accountcomponent.applicationlike.AccountApplicationLike");
				break;
			case R.id.btn_unregister:
				Router.unregisterComponent("com.johnson.router.accountcomponent.applicationlike.AccountApplicationLike");
				break;
		}
	}

	// UI transfer with Bundle
	private void goToShareActivityWithBundle() {
		Author author = new Author();
		author.setName("Margaret Mitchell");
		author.setCounty("USA");
		Bundle bundle = new Bundle();
		bundle.putString("bookName", "Gone with the Wind");
		bundle.putString("author", JsonService.Factory.getInstance().create().toJsonString(author));
		UIRouter.getInstance().openUri(this, "DDComp://Account/Login", bundle);
	}

	// UI transfer with URI
	private void goToShareActivityWithUri() {
		Author author = new Author();
		author.setName("Barack Obama");
		author.setCounty("New York");
		UIRouter.getInstance().openUri(this,
				"DDComp://kotlin/shareMagazine?bookName=NYTIME&author="
						+ JsonService.Factory.getInstance().create().toJsonString(author), null);
	}

	//startActivityForResult
	private void goToShareActivityForResult() {
		Author author = new Author();
		author.setName("Margaret Mitchell");
		author.setCounty("USA");
		UIRouter.getInstance().openUri(this,
				"DDComp://share/shareBook?bookName=Gone with the Wind&author="
						+ JsonService.Factory.getInstance().create().toJsonString(author), null, REQUEST_CODE);
	}
}
