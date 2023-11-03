/**
# COPYRIGHT LICENSE: 
# This information contains sample code provided in source code form. You may 
# copy, modify, and distribute these sample programs in any form without 
# payment to FBI Partner for the purposes of developing, using, marketing or 
# distributing application programs conforming to the application programming
# interface for the operating platform for which the sample code is written. 
# Notwithstanding anything to the contrary, FBI Partner PROVIDES THE SAMPLE SOURCE CODE
# ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, 
# INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF 
# MERCHANTABILITY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, 
# TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE 
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO 
# OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR 
# MODIFICATIONS TO THE SAMPLE SOURCE CODE.
**/

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

public class nonPoliceServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8), 0);
        server.createContext("/", new nonPoliceHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class nonPoliceHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
	nonPoliceMVC mvc = new nonPoliceMVC();
	mvc.nonPoliceBusinessDelegate();
   String root = mvc.nonPoliceRoot();
    URI uri = t.getRequestURI();
    File file = new File(new nonPoliceMVC().nonPoliceFile()).getCanonicalFile();
   
      t.sendResponseHeaders(200, 0);
      OutputStream os = t.getResponseBody();
      FileInputStream fs = new FileInputStream(file);
      final byte[] buffer = new byte[0x10000];
      int count = 0;
      while ((count = fs.read(buffer)) >= 0) {
        os.write(buffer,0,count);

      fs.close();
      os.close();
}}}}