package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardFileDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoardName() {
		return "NOTICE";
	}

	@PostMapping("setContentsImg")
	public String setContentsImage(MultipartFile files, HttpSession session,Model model) throws Exception{
		System.out.println("setContentsImg");
		System.out.println(files.getOriginalFilename());
		String path = noticeService.setContentsImg(files, session);
		model.addAttribute("result", path);
		return "commons/ajaxResult";
	}
	
	@PostMapping("setContentsImgDelete")
	public String setContentsImgDelete(String path, Model model, HttpSession session)throws Exception{
		boolean check = noticeService.setContentsImgDelete(path, session);
		model.addAttribute("result", check);
		return "commons/ajaxResult";
	}
	
	@RequestMapping("list")
	public String getList(Model model, Pager pager) throws Exception {
		List<BoardDTO> ar = noticeService.getList(pager);

		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "./board/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception {

		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		if (boardDTO==null) {
			model.addAttribute("message", "글이 없다");
			model.addAttribute("url","list");
			
			return "commons/result";
		} else {
			model.addAttribute("bto", boardDTO);
			return "board/detail";
			
		}

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd() throws Exception {
		return "board/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO, MultipartFile[] photos, HttpSession session, Model model) throws Exception {
		int result = noticeService.setAdd(boardDTO, photos, session);

		String message = "등록 실패";
		if (result > 0) {
			message = "등록 성공";
		}

		model.addAttribute("message", message);
		model.addAttribute("url", "list");
		return "commons/result";
	}
//	redirect는 상대, 절대 다됨

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(NoticeDTO noticeDTO,ModelAndView mv) throws Exception {
		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		mv.addObject("bto", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO, MultipartFile[] photos, HttpSession session) throws Exception {
		System.out.println(photos.length);
		int result = noticeService.setUpdate(boardDTO, photos, session);
		return "redirect:./detail?boardNum=" + boardDTO.getBoardNum();
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String setDelete(NoticeDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./list";
	}
	
	@GetMapping("fileDelete")
	public String setFileDelete(NoticeFileDTO noticeFileDTO, Model model, HttpSession session) throws Exception{
		   int result = noticeService.setFileDelete(noticeFileDTO,session);
		   model.addAttribute("result",result);
		   
		   return "commons/ajaxResult";
		   
	}

}
