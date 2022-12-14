package com.servlet.study.web.servlet.cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@WebServlet("/cookie/test")
public class CookieTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		
		//api 요청
		if(flag != null) {
			Cookie[] cookies = request.getCookies();
			Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
			
			Map<String, Object> jsonObject = new HashMap<String, Object>();
			List<JsonObject> jsonObjects = new ArrayList<JsonObject>();
			
			for(Cookie cookie : cookies) {
				JsonObject object = new JsonObject();
				object.addProperty("name", cookie.getName());
				object.addProperty("vlaue", cookie.getValue());
				object.addProperty("domain", cookie.getDomain());
				object.addProperty("path", cookie.getPath());
				object.addProperty("maxAge", cookie.getMaxAge());
				jsonObjects.add(object);
			}
			
			jsonObject.put("cookies", jsonObjects);
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(gson.toJson(jsonObject));
			
		}else {
			//page 요청
			request.getRequestDispatcher("/WEB-INF/viwes/cookie.jsp").forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
