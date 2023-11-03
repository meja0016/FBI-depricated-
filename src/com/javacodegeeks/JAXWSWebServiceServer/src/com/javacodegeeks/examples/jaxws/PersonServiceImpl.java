package com.javacodegeeks.examples.jaxws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.javacodegeeks.examples.jaxws.PersonServiceI")
public class PersonServiceImpl implements PersonServiceI {

	@Override
	public Person getPerson(Integer id) {
		return PersonUtil.getPerson(id);
	}

}
