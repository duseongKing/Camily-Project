package com.camily.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camily.dto.BoardDto;
import com.camily.dto.GoodsReviewDto;
import com.camily.service.GoodsReviewService;

@Controller
public class GoodsReviewController {

	@Autowired
	private HttpSession session;

	@Autowired
	GoodsReviewService grvc;

	// 캠핑용품 후기 페이지
	@RequestMapping(value = "/goreviewpage")
	public ModelAndView goreviewpage() {
		System.out.println("캠핑용품 리뷰 페이지 이동 요청");
		ModelAndView mav = grvc.goreviewpage();

		return mav;
	}

	// 캠핑용품 후기 상세페이지 
	@RequestMapping(value = "/goreviewdetailpage")
	public ModelAndView goreviewdetailpage(int gorvcode) {
		System.out.println("캠핑용품 리뷰 상세페이지 이동요청");
		ModelAndView mav = grvc.goreviewdetailpage(gorvcode);

		return mav;
	}
	
	// 캠핑용품 후기 작성
	@GetMapping("cgWrite")
	public String cgWrite(String image, String gogcode, String gocode) {
		System.out.println("GoodsReviewController.CgWrite()호출");
		System.out.println("gogcode" + gogcode);
		System.out.println("image" + image);

		session.setAttribute("cgimage", image);
		session.setAttribute("cggcode", gogcode);
		session.setAttribute("gocode", gocode);

		return "board/BoardWrite2";
	}
	
	// 캠핑용품 후기 작성
	@RequestMapping("cgWrite2")
	public String cgWrite2(GoodsReviewDto grdo, RedirectAttributes ra) {
		System.out.println("GoodsReviewController.CampingGoodsWrite()호출");
		System.out.println(grdo);

		int insertResult = grvc.insertGoodsReview(grdo, ra);
		System.out.println("insertResult :" + insertResult);
		return "redirect:/goreviewpage";
	}

	// 캠핑용품 후기 수정 
	@RequestMapping(value = "/goreviewModify")
	public ModelAndView goReviewModify(int gorvcode) {
		System.out.println("캠핑용품 후기 수정 기능 요청");
		ModelAndView mav = grvc.goreviewModify(gorvcode);
		return mav;
	}
	
	// 캠핑용품 후기 수정폼
	@RequestMapping(value = "/goreviewModifyForm")
	public ModelAndView goReviewModifyForm(GoodsReviewDto goreview, RedirectAttributes ra) {
		System.out.println("캠핑용품 후기 수정 기능 요청");
		System.out.println("goreview :" + goreview);
		ModelAndView mav = grvc.goreviewModifyForm(goreview,ra);
		return mav;
	}

	// 캠핑용품 후기 삭제
	@RequestMapping(value = "/goreviewDelete")
	public ModelAndView goreviewDelete(int gorvcode, RedirectAttributes ra) {
		System.out.println("캠핑용품 후기 게시물 삭제 요청");
		ModelAndView mav = grvc.goreviewDelete(gorvcode, ra);

		return mav;
	}

}
