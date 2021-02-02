package co.micol.rental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;

public class User implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 회원별 조회
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo = new BookRentalVo();
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		
		vo.setmId(requset.getParameter("mId"));
		vo.setbCode(requset.getParameter("bCode"));
		
		HttpSession session = requset.getSession();
		String value = (String)session.getAttribute("mid");

		vo.setmId(value);

		
		
		
		list = dao.selMem(vo);
		requset.setAttribute("list", list);
		requset.setAttribute("vo", vo);
		
		System.out.println(vo);
		
		return "rentaluser/userForm";
	}

}
