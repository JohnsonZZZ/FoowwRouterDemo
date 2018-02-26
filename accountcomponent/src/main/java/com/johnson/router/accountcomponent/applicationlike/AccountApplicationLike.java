package com.johnson.router.accountcomponent.applicationlike;


import com.johnson.component.componentlib.applicationlike.IApplicationLike;
import com.johnson.component.componentlib.router.Router;
import com.johnson.component.componentlib.router.ui.UIRouter;

;

/**
 * Created by JohnsonFan on 2018/2/24.
 */

public class AccountApplicationLike implements IApplicationLike {
	Router router = Router.getInstance();
	UIRouter uiRouter = UIRouter.getInstance();

	@Override
	public void onCreate() {
		uiRouter.registerUI("account");
//		router.addService(ReadBookService.class.getSimpleName(), new ReadBookServiceImpl());
	}

	@Override
	public void onStop() {
		uiRouter.unregisterUI("account");
//		router.removeService(ReadBookService.class.getSimpleName());
	}
}
