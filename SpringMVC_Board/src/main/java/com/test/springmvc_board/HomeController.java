package com.test.springmvc_board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.test.springmvc_board.bean.BoardBean;
import com.test.springmvc_board.bean.UserBean;

/**
 * Handles requests for the application home page.
 */
/*
 * [파라미터 한글 깨지는 것 처리]
 *   web.xml의 filter 태그 참조
 *   
 * [라이브러리 설정]
 *   pom.xml
 * 
 * [MyBatis 및 bean 설정]
 *  src/main/webapp/WEB-INF/spring/root-context.xml
 */
@Controller
// ModelAndView 객체에 객체를 셋팅할때
// login_bean이라는 이름으로 셋팅하면
// request가 아닌 session 영역에 저장되도록 한다.
@SessionAttributes({"login_bean", "login_chk"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// 데이터베이스 처리를 위한 객체
	// @Autowired -> byType
	//   - 정의되어 있는 빈 중에 클래스타입이 같은 
	//     빈을 자동 주입
	// @autowired 밑에 @Qualifier("빈id") -> byName
	//   - 정의되어 있는 빈 중에 id가 빈id로 되어있는
	//     빈을 자동 주입
	@Autowired	
	private SqlSessionTemplate temp;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// 파라미터 없음
	// 세션 사용 안함
	public ModelAndView user_main_view(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		// 최종 뷰 셋팅
		mv.setViewName("user/user_main_view");
		return mv;
	}
	
	@RequestMapping(value = "/join_main", method = RequestMethod.GET)
	// 파라미터 없음
	// 세션 사용 안함
	public ModelAndView join_main(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/join_main");
		return mv;
	}
	
	@RequestMapping(value = "/join_pro", method = RequestMethod.POST)
	// 파라미터 있음 - 두 번째 매개변수
	// 세션 사용 안함
	public ModelAndView join_pro(HttpServletRequest request,  @ModelAttribute("param") UserBean param, HttpServletResponse response){
		// SqlSessionTemplate 객체를 이용해
		// 쿼리를 실행한다.
		temp.insert("com.mvc.mapper.add_user", param);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/join_pro");
		return mv;
	}
	
	@RequestMapping(value = "/join_result", method = RequestMethod.GET)
	// 파라미터 없음
	// 세션 사용 안함
	public ModelAndView join_result(HttpServletRequest request,  HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/join_result");
		return mv;
	}
	
	@RequestMapping(value = "/login_pro", method = RequestMethod.GET)
	// 파라미터 있음
	// 세션 사용 안함
	public ModelAndView login_pro(HttpServletRequest request,  @ModelAttribute("param") UserBean param, HttpServletResponse response){
		// 데이터 베이스에서 데이터를 가져온다.
		UserBean user_bean = temp.selectOne("com.mvc.mapper.chk_login", param);
		// 로그인 성공확인
		ModelAndView mv = new ModelAndView();
		
		if(user_bean != null){	// 로그인 성공
			// 사용자 정보를 세션에 저장
			mv.addObject("login_bean", user_bean);
			mv.addObject("login_chk", true);
			// 브라우저에게 board_main을 요청하도록한다.
			mv.setViewName("redirect:board_main");
		} else {				// 로그인 실패
			mv.setViewName("user/login_fail");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/board_main", method = RequestMethod.GET)
	// 파라미터 없음
	// 세션 사용
	public ModelAndView board_main(HttpSession session, HttpServletRequest request,  HttpServletResponse response){
		
		// 세션에서 로그인 여부 값을 가져온다.
		Boolean login_chk = (Boolean)session.getAttribute("login_chk");
				
		ModelAndView mv = new ModelAndView();
		
		if(login_chk != null && login_chk == true){
			// 데이터베이스에서 글 목록 데이터를 가져온다.
			// import java.util.List
			List<BoardBean> board_list = temp.selectList("com.mvc.mapper.get_board_list");
			mv.addObject("board_list", board_list);
			
			mv.setViewName("board/board_main");
		} else {
			mv.setViewName("redirect:/");
		}
				
		return mv;
	}
	
	@RequestMapping(value = "/board_write", method = RequestMethod.GET)
	// 파라미터 없음
	// 세션 사용
	public ModelAndView board_write(HttpSession session, HttpServletRequest request,  HttpServletResponse response){
		// 세션에서 로그인 여부 값을 가져온다.
		Boolean login_chk = (Boolean)session.getAttribute("login_chk");				
		ModelAndView mv = new ModelAndView();		
		if(login_chk != null && login_chk == true){
			mv.setViewName("board/board_write");
		} else {
			mv.setViewName("redirect:/");
		}
				
		return mv;
	}
	
	@RequestMapping(value = "/board_write_pro", method = RequestMethod.POST)
	// 파라미터 없음
	// 세션 사용
	public ModelAndView board_write_pro(HttpSession session, HttpServletRequest request,  @ModelAttribute("param") BoardBean param, HttpServletResponse response){
		// 세션에서 로그인 여부 값을 가져온다.
		Boolean login_chk = (Boolean)session.getAttribute("login_chk");				
		ModelAndView mv = new ModelAndView();		
		if(login_chk != null && login_chk == true){
			// 세션에서 사용자 정보를 가져온다.
			UserBean login_bean = (UserBean)session.getAttribute("login_bean");
			// 로그인한 사용자의 인덱스를 작성자 인덱스에
			// 넣어준다.
			param.setBoard_writer_idx(login_bean.getUser_idx());
			// 데이터베이스에 저장한다.
			temp.insert("com.mvc.mapper.add_board", param);
			
			mv.setViewName("board/board_write_pro");
		} else {
			mv.setViewName("redirect:/");
		}
				
		return mv;
	}
	
	@RequestMapping(value = "/board_read", method = RequestMethod.GET)
	// 파라미터 없음
	// 세션 사용
	public ModelAndView board_read(HttpSession session, HttpServletRequest request,  @RequestParam("board_idx") int board_idx, HttpServletResponse response){
		// 세션에서 로그인 여부 값을 가져온다.
		Boolean login_chk = (Boolean)session.getAttribute("login_chk");				
		ModelAndView mv = new ModelAndView();		
		if(login_chk != null && login_chk == true){
			// 데이터베이스에서 글 정보를 가져온다.
			BoardBean board_bean = temp.selectOne("com.mvc.mapper.get_board_content", board_idx);
			// 글정보를 Request영역에 저장한다.
			mv.addObject("board_bean", board_bean);
			
			mv.setViewName("board/board_read");
		} else {
			mv.setViewName("redirect:/");
		}
				
		return mv;
	}
	
}













