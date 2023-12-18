package com.poly.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.VideoDao;
import com.poly.entity.Video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admindetail/*", "/videodetail/*", "/userdetail/*", "/reportdetail/*" })

public class HomeCtrlAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("videodetail") || uri.contains("videoediton")) {
			VideoDao vdd = new VideoDao();
			req.setAttribute("videos", vdd.findAll());
			req.setAttribute("viewad", "/views/admin/ManagementVideo/indexMnUs.jsp");
			req.setAttribute("view123", "/views/admin/ManagementVideo/VideoEdition.jsp");
			String view123 = req.getParameter("view123");
			if ("videolist".equals(view123)) {
				req.setAttribute("view123", "/views/admin/ManagementVideo/VideoAdList.jsp");
			} else if ("videoedition".equals(view123)) {
				req.setAttribute("view123", "/views/admin/ManagementVideo/VideoEdition.jsp");
			}
		}

		if (uri.contains("userdetail") || uri.contains("Useredition")) {
			req.setAttribute("viewad", "/views/admin/ManagementUser/ListEdition.jsp");
			req.setAttribute("viewUser", "/views/admin/ManagementUser/Edition.jsp");
			System.out.println("setoke");

			String viewuser = req.getParameter("viewuser");
			System.out.println(viewuser);
			if ("userlist".equals(viewuser)) {
				req.setAttribute("viewUser", "/views/admin/ManagementUser/listUser.jsp");
			} else if ("useredition".equals(viewuser)) {
				req.setAttribute("viewUser", "/views/admin/ManagementUser/Edition.jsp");
			}

		}

		VideoDao dao = new VideoDao();
		Video vd = new Video();

		try {
			if (uri.contains("adeditvideo")) {
				System.out.println("oke");
				String id = uri.substring(uri.lastIndexOf("/") + 1);
				System.out.println("idla" + id);
				vd = dao.findById(id);
				req.setAttribute("form", vd);
				System.out.println(vd.getPoster());

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (uri.contains("reportdetail") || uri.contains("viewreport")) {

			req.setAttribute("viewad", "/views/admin/ReportAd/Navbar.jsp");
			req.setAttribute("viewReport", "/views/admin/ReportAd/Favorite.jsp");
			System.out.println("setoke");

			String viewreport = req.getParameter("viewreport");
			System.out.println(viewreport);
			if ("favorite".equals(viewreport)) {
				req.setAttribute("viewReport", "/views/admin/ReportAd/Favorite.jsp");
			} else if ("favoriteuser".equals(viewreport)) {
				req.setAttribute("viewReport", "/views/admin/ReportAd/FavoriteUser.jsp");
			} else if ("sharefriend".equals(viewreport)) {
				req.setAttribute("viewReport", "/views/admin/ReportAd/ShareFriend.jsp");
			}
		}

		req.getRequestDispatcher("/views/admin/ManagementVideo/index.jsp").forward(req, resp);

	}

	protected void editVd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDao dao = new VideoDao();
		Video vd = new Video();
		String uri = req.getRequestURI();
		try {
			if (uri.contains("edit")) {
				String id = uri.substring(uri.lastIndexOf("/") + 1);
				vd = dao.findById(id);
				req.setAttribute("form", vd);
			}
		} catch (Exception e) {

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mes1 = "";
		VideoDao dao = new VideoDao();
		Video vd1 = new Video();
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf('/');
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		String redirectURI = uri.substring(0, lastIndex - 1);
		if (uri.contains("createvd")) {
			try {
				BeanUtils.populate(vd1, req.getParameterMap());
				dao.create(vd1);
				redirectURI += "/" + vd1.getId();
				id = vd1.getId();
				mes1 = "Success";
				req.setAttribute("message", "Thêm mới thành công");
			} catch (Exception e) {
				e.printStackTrace();
				mes1 = "Fail";
				req.setAttribute("message", "Thêm mới thất bại rồi");
			}
		} else if (uri.contains("deletevd")) {
			try {
				redirectURI += "/" + id;

				dao.remove(id);
				mes1 = "Success";
				req.setAttribute("message", "Xoá thành công");

			} catch (Exception e) {
				mes1 = "Fail";

				req.setAttribute("message", "Xoá thất bại");
			}
		} else if (uri.contains("updatevd")) {
			System.out.println("vào update");

			try {
				Video form = new Video();
				BeanUtils.populate(form, req.getParameterMap());
				form.setId(id);
				redirectURI += "/" + id;

				form.setPoster(dao.findPoster(id));
				dao.update(form);
				mes1 = "Success";
				resp.encodeRedirectURL(mes1);
				req.getSession().setAttribute("messageUser", "Cập nhật thành công !");

			} catch (Exception e) {
				mes1 = "Fail";
				e.printStackTrace();
				req.getSession().setAttribute("messageUser", "Cập nhật thất bại");

			}
		}


		resp.sendRedirect(redirectURI + "?ms=" + mes1);

	}

}
