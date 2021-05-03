package com.ashi;

import org.springframework.stereotype.Component;

@Component()
public class OuterPackageBean  implements IOuter{
	
	public String getMsg() {
		return "Msg from OuterPackageBean :: getMsg";
	}
}
