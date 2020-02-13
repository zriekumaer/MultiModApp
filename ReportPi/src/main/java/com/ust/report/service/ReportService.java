package com.ust.report.service;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException;
}
