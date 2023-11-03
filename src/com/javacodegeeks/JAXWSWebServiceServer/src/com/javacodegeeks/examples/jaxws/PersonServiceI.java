package com.javacodegeeks.examples.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface PersonServiceI {
	@WebMethod
	Person getPerson(Integer id);
}
