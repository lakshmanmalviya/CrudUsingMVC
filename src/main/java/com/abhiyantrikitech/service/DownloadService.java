package com.abhiyantrikitech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiyantrikitech.dto.DownloadRequest;
import com.abhiyantrikitech.repository.DownloadDao;

@Service
public class DownloadService {

	@Autowired
	DownloadDao downloadDao;

	public DownloadRequest saveDonwloadRequest(DownloadRequest downloadRequest) throws Exception {
		return downloadDao.saveDonwloadRequest(downloadRequest);
	}

	public DownloadRequest getDonwloadRequest(Long id) throws Exception {
		return downloadDao.getDonwloadRequest(id);
	}

	public List<DownloadRequest> getAllDonwloadRequest() throws Exception {
		return downloadDao.getAllDonwloadRequest();
	}

	public DownloadRequest updateDonwloadRequest(DownloadRequest downloadRequest, Long id) throws Exception {
		return downloadDao.updateDownloadRequestById(downloadRequest, id);
	}
}