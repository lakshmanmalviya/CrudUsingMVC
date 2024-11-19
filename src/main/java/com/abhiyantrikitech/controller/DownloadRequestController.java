package com.abhiyantrikitech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.abhiyantrikitech.dto.DownloadRequest;
import com.abhiyantrikitech.service.DownloadService;

@Controller
public class DownloadRequestController {

	@Autowired
	DownloadService downloadService;

	@RequestMapping(value = "/createDownloadRequest", method = RequestMethod.POST)
	public String createDownloadRequest(ModelMap model,
			@ModelAttribute("DownloadRequest") DownloadRequest downloadRequest) throws Exception {
		System.out.println("Request is coming......");
		model.put("downloadDetails", downloadService.saveDonwloadRequest(downloadRequest));
		return "home";
	}

	@RequestMapping(value = "/updateDownloadRequest/{id}", method = RequestMethod.PUT)
	public String updateDonwloadRequest(ModelMap model,
			@ModelAttribute("DownloadRequest") DownloadRequest downloadRequest, @PathVariable Long id)
			throws Exception {
		model.put("downloadDetails", downloadService.updateDonwloadRequest(downloadRequest, id));
		return "home";
	}

	@RequestMapping(value = "/getDownloadRequest/{id}", method = RequestMethod.GET)
	public String getDownloadRequest(ModelMap model, @PathVariable Long id) throws Exception {
		model.put("downloadDetails", downloadService.getDonwloadRequest(id));
		return "home";
	}

	@RequestMapping(value = "/getAllDownloadRequest", method = RequestMethod.GET)
	public String getAllDownloadRequest(ModelMap model) throws Exception {
		model.put("downloadDetails", downloadService.getAllDonwloadRequest());
		return "home";
	}

}
