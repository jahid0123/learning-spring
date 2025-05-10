package com.jmjbrothers.student_management_system.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class JasperReportService {

	@Autowired
	private DataSource dataSource;

	public byte[] generateEmployeeReport() throws JRException, SQLException, IOException {

		ClassPathResource resource = new ClassPathResource("/reports/First_Report.jrxml");
		InputStream reportSource = resource.getInputStream();

		JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

		try (Connection conn = dataSource.getConnection()) {

			Map<String, Object> parameters = new HashMap<>();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

			return JasperExportManager.exportReportToPdf(jasperPrint);
		}
	}

}
