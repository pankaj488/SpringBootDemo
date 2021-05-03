package com.ashi;

import org.springframework.stereotype.Component;

@Component()
public class OuterPackageBeanA  implements IOuter{

	public String getMsg() {
		return "Msg from OuterPackageBeanA :: getMsg";
	}
}
