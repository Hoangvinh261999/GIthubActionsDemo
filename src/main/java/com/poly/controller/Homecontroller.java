package com.poly.controller;

import java.io.IOException;
import java.util.List;

import com.poly.dao.UserDao;
import com.poly.dao.VideoDao;
import com.poly.entity.User;
import com.poly.entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/index/*", "/page", "/like", "/menu", "/detail", "/login", "/forgotpass", "/share", "/update",
		"/register", "/changepass", "/editprofile", "/favorite" })
public class Homecontroller extends HttpServlet {

	private static final long serialVersionUID = 4819438711230913810L;
	List<Video> subListPage;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		UserDao dao = new UserDao();
		VideoDao vddao = new VideoDao();
		List<Video> listvd = vddao.findAll();
		String uri = req.getRequestURI();
		if (uri.contains("detail")) {
			String id = req.getParameter("idlist");

			req.setAttribute("idlist", id);
			vddao.findById(id);
			req.setAttribute("videodetail", vddao.findById(id));
			req.setAttribute("view", "/views/user/detail.jsp");
		}
		if (uri.contains("login")) {

			req.setAttribute("view", "/views/user/login.jsp");
		}
		if (uri.contains("index")) {
			setCookie(resp, "pageSession", "0"); // Đặt giá trị trang hiện tại vào cookie

			req.setAttribute("subListPage", listvd.subList(0, 6));


			req.setAttribute("view", "/views/user/listvd.jsp");
		}
		if (uri.contains("forgotpass")) {
			req.setAttribute("view", "/views/user/forgotpass.jsp");
		}
		if (uri.contains("register")) {
			req.setAttribute("view", "/views/user/register.jsp");
		}
		if (uri.contains("changepass")) {
			req.setAttribute("view", "/views/user/changepass.jsp");
		}
		if (uri.contains("editprofile")) {
			req.setAttribute("view", "/views/user/updateAccount.jsp");
		}
		if (uri.contains("favorite")) {
			req.setAttribute("view", "/views/user/favorite.jsp");
		}
		if (uri.contains("page")) {
			int n = listvd.size();
			int m = 6;
			int sessionPageFirt = getCurrentPage(req); // Lấy giá trị trang hiện tại từ cookie

			int totalPages = (int) Math.ceil((double) n / m);
			String pageChange = req.getParameter("idp");

			if (pageChange.equalsIgnoreCase("first")) {
				subListPage = listvd.subList(0, Math.min(m, n));
				req.setAttribute("subListPage", subListPage);
				setCookie(resp, "pageSession", "0"); // Đặt giá trị trang hiện tại vào cookie
			} else if (pageChange.equalsIgnoreCase("next")) {
				nextPage(resp, req, n, m, sessionPageFirt, totalPages, pageChange, listvd);
			} else if (pageChange.equalsIgnoreCase("Last")) {
				lastPage(resp, req, n, m, sessionPageFirt, totalPages, pageChange, listvd);
			} else if (pageChange.equalsIgnoreCase("Previous")) {
				previousPage(resp, req, n, m, sessionPageFirt, totalPages, pageChange, listvd);
			}
		}

		req.setAttribute("listvd", listvd);
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}

	private void setCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(1200); 
		response.addCookie(cookie);
	}

	private int getCurrentPage(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("pageSession".equals(cookie.getName())) {
					try {
						return Integer.parseInt(cookie.getValue());
					} catch (NumberFormatException e) {

					}
				}
			}
		}
		return 0; 
	}

	public void nextPage(HttpServletResponse resp, HttpServletRequest req, int n, int m, int sessionPageFirt,
			int totalPages, String pagechange, List<Video> listvd) {
		int sessionPage1 = sessionPageFirt + 1;
		if (sessionPage1 < totalPages) {
			int startIndex = m * sessionPage1;
			int endIndex = Math.min(startIndex + m, n);

			subListPage = listvd.subList(startIndex, endIndex);
			req.setAttribute("subListPage", subListPage);
			setCookie(resp, "pageSession", String.valueOf(sessionPage1)); // Đặt giá trị trang hiện tại vào cookie
		} else {
			subListPage = listvd.subList(0, Math.min(m, n));
			req.setAttribute("subListPage", subListPage);
			setCookie(resp, "pageSession", "0"); // Đặt giá trị trang hiện tại vào cookie
		}

	}
	
	public void previousPage(HttpServletResponse resp, HttpServletRequest req, int n, int m, int sessionPageFirt,
			int totalPages, String pagechange, List<Video> listvd) {
		int sessionPage1 = sessionPageFirt - 1;

		if (sessionPage1 >= 0) {
			int startIndex = m * sessionPage1;
			int endIndex = Math.min(startIndex + m, n);

			subListPage = listvd.subList(startIndex, endIndex);
			req.setAttribute("subListPage", subListPage);
			setCookie(resp, "pageSession", String.valueOf(sessionPage1)); 
		} else {
			int sessionPageLast = totalPages - 1;
			int startIndex = m * sessionPageLast;
			int endIndex = Math.min(startIndex + m, n);

			subListPage = listvd.subList(startIndex, endIndex);
			req.setAttribute("subListPage", subListPage);
			setCookie(resp, "pageSession", String.valueOf(sessionPageLast));

		}
		
		

	}
	public void lastPage(HttpServletResponse resp, HttpServletRequest req, int n, int m, int sessionPageFirt,
			int totalPages, String pagechange, List<Video> listvd) {

		int sessionPageLast = totalPages - 1;
		int startIndex = m * sessionPageLast;
		int endIndex = Math.min(startIndex + m, n);

		subListPage = listvd.subList(startIndex, endIndex);
		req.setAttribute("subListPage", subListPage);
		setCookie(resp, "pageSession", String.valueOf(sessionPageLast));

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		VideoDao vddao = new VideoDao();
		List<Video> listvd = vddao.findAll();
		User user = new User();
		UserDao dao = new UserDao();
		String us = req.getParameter("username");
		String pw = req.getParameter("password");
		try {
			User entity = dao.findById(us);
			if (!entity.getPassword().equals(pw)) {
				System.out.println("sai pass");
			} else {
				req.setAttribute("view", "/views/user/listvd.jsp");
				listvd = vddao.findAll();

				req.setAttribute("listvd", listvd);
				req.getSession().setAttribute("userlogin", entity);
				req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);

			}
		} catch (Exception e) {
		}
	}



}

//<script>
//var isLiked = ${videodetail.liked};
//
//function toggleLike() {
//    isLiked = !isLiked; 
//    var likeButton = document.getElementById("likeButton");
//
//    if (isLiked) {
//        likeButton.innerHTML = "Bỏ thích";
//
//    } else {
//        likeButton.innerHTML = "Thích";
//
//    }
//}
//</script>
