<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
# COPYRIGHT LICENSE: 
# This information contains sample code provided in source code form. You may 
# copy, modify, and distribute these sample programs in any form without 
# payment to IBM for the purposes of developing, using, marketing or 
# distributing application programs conforming to the application programming
# interface for the operating platform for which the sample code is written. 
# Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE
# ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, 
# INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF 
# MERCHANTABILITY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, 
# TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE 
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO 
# OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR 
# MODIFICATIONS TO THE SAMPLE SOURCE CODE.
-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JAX-WS Web Services MTOM Sample</title>
</head>
<body>
<P align="center"><B><FONT size="+2">JAX-WS Web Services MTOM Sample
</FONT></B></P>
<H3><B> <U>Message Options</U></B></H3>
<FORM name="mtomdemo" method="POST" action="/wssamplemtom/demo" enctype="multipart/form-data">
<TABLE border="0" cellpadding="0" cellspacing="1">
	<TBODY>
		<TR>
			<TD>
			<TABLE border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCC22">
				<TBODY>	
					<TR>
						<TD><B>Service Type:</B></TD>
						<TD><B><SELECT name="msgservice">
							<OPTION value="Dispatch" <%=request.getAttribute("DispatchSelected")%>>Dispatch</OPTION>
							<OPTION value="Proxy" <%=request.getAttribute("ProxySelected")%>>Proxy</OPTION>
						</SELECT></B></TD>
						<TD></TD>
					</TR>			
					<TR>
						<TD><B>Source Filename:</B></TD>
						<TD><B><INPUT type="file" name="filedef" size="32"
							value="<%=request.getAttribute("filedef")%>"></B></TD>
					</TR>
					<TR>
						<TD><BR>
						</TD>
						<TD></TD>
						<TD></TD>
					</TR>
					<TR>
						<TD><B>Service URI:</B></TD>
						<TD><B><INPUT type="text" name="uridef" size="40"
							value="<%=request.getAttribute("uridef")%>"></B></TD>
						<TD></TD>
					</TR>
					<TR>
						<TD><BR>
						</TD>
						<TD><FONT size="-1">example:
						http://ServiceHostname:port</FONT></TD>
						<TD></TD>
					</TR>
					<TR>
						<TD><BR>
						</TD>
						<TD></TD>
						<TD></TD>
					</TR>
					<TR>
						<TD><B>SOAP:</B></TD>
						<TD><INPUT type="checkbox" name="soapdef"
							<%=request.getAttribute("soapdef")%>>Use SOAP 1.2</TD>
						<TD></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
		<TR>
			<TD>
			<TABLE width="50" border="0" cellpadding="0" cellspacing="1">
				<TBODY>
					<TR>
						<TD><INPUT type="submit" name="SUBMIT" value="Send Message">
					</TR>
					<TR>
						<TD><TEXTAREA rows="20" cols="60" name="OUTPUT" readonly
							style="background:#FAE622" style="font-weight: bold"
							style="border-style:solid">
							<%=request.getAttribute("messageS")%>
							<%=request.getAttribute("messageR")%>
							</TEXTAREA>
						</TD>
						<TD></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</FORM>
</body>
</html>