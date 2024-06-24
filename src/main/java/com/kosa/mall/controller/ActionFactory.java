package com.kosa.mall.controller;

import com.kosa.mall.controller.action.*;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if ("index".equals(command)) {
			action = new IndexAction();
		} else if ("login_form".equals(command)) {
			action = new LoginFormAction();
		} else if ("login".equals(command)) {
			action = new LoginAction();
		} else if ("logout".equals(command)) {
			action = new LogoutAction();
		} else if ("product_detail".equals(command)) {
			action = new ProductDetailAction();
		} else if ("add_to_cart".equals(command)) {
			action = new AddToCartAction();
		} else if ("cart_list".equals(command)) {
			action = new CartListAction();
		} else if ("update_cart".equals(command)) {
			action = new UpdateCartAction();
		} else if ("remove_from_cart".equals(command)) {
			action = new RemoveFromCartAction();
		} else if ("contract".equals(command)) {
			action = new ContractAction();
		} else if ("join".equals(command)) {
			action = new RegisterFormAction();
		} else if ("id_check_form".equals(command)) {
			action = new IdCheckFormAction();
		} else if ("find_zip_num".equals(command)) {
			action = new FindZipNumAction();
		}

		return action;
	}
}
