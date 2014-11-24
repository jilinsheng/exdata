/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mingda.exdata;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Administrator
 */
public class Gen {

	@SuppressWarnings("unused")
	public void GenXLS(String onno, String dirpath,List<ApplyDTO> l1,List<ApplyDTO> l2) {
		try {
			File dir1 = new File(dirpath + "\\" + onno);
			File dir2 = new File(dirpath + "\\" + onno + "\\SFZ");

			if (!dir1.exists()) {
				System.out.println(dir1);
				dir1.mkdirs();
				System.out.println(dir2);
				dir2.mkdirs();
			}

			File file = new File(dirpath + "\\" + onno + "\\" + onno + ".xls");
			if (!file.exists()) {
				file.createNewFile();
			}
			int startRowNum = 0;// 起始行
			int startColNum = 0;// 起始列
			int maxColSize = 4;// 最大列数
			WritableWorkbook wb = Workbook.createWorkbook(file);
			WritableSheet ws1 = wb.createSheet("apply", 0);
			WritableSheet ws2 = wb.createSheet("family_members", 1);
			WritableSheet ws3 = wb.createSheet("material", 2);

			ReadData rd = new ReadData();
			//List<ApplyDTO> l1 = rd.getData1(uuid);
			// 主申请人姓名 证件类型 证件号码 委托时间

			ws1.addCell(new Label(0, startRowNum, "主申请人姓名"));
			ws1.addCell(new Label(1, startRowNum, "证件类型"));
			ws1.addCell(new Label(2, startRowNum, "证件号码"));
			ws1.addCell(new Label(3, startRowNum, "委托时间"));
			startRowNum++;
			for (ApplyDTO e : l1) {
				ws1.addCell(new Label(0, startRowNum, e.getMastername()));
				ws1.addCell(new Label(1, startRowNum, e.getIdtype()));
				ws1.addCell(new Label(2, startRowNum, e.getMasteridcard()));
				ws1.addCell(new Label(3, startRowNum, e.getWt()));
				startRowNum++;
			}
			startRowNum = 0;// 起始行
			startColNum = 0;// 起始列
			maxColSize = 4;// 最大列数
			// 主申请人身份证号 姓名 性别 身份证号 与主申请关系

			ws2.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws2.addCell(new Label(1, startRowNum, "姓名"));
			ws2.addCell(new Label(2, startRowNum, "性别"));
			ws2.addCell(new Label(3, startRowNum, "身份证号"));
			ws2.addCell(new Label(4, startRowNum, "与主申请关系"));

			ws3.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws3.addCell(new Label(1, startRowNum, "名称"));
			ws3.addCell(new Label(2, startRowNum, "种类"));
			startRowNum++;
			//List<ApplyDTO> l2 = rd.getData2(uuid);
			for (ApplyDTO e : l2) {
				ws2.addCell(new Label(0, startRowNum, e.getMasteridcard()));
				ws2.addCell(new Label(1, startRowNum, e.getMembername()));
				ws2.addCell(new Label(2, startRowNum, e.getSex()));
				ws2.addCell(new Label(3, startRowNum, e.getMemberidcard()));
				ws2.addCell(new Label(4, startRowNum, e.getRelmaster()));

				File yfile = new File("Z:\\exdata\\c.jpg");
				if (yfile.exists()) {
					ws3.addCell(new Label(0, startRowNum, e.getMemberidcard()));
					ws3.addCell(new Label(1, startRowNum, e.getMemberidcard()
							+ ".jpg"));
					ws3.addCell(new Label(2, startRowNum, "身份证复印件"));
					File idpic = new File(dirpath + "\\" + onno + "\\SFZ\\"
							+ e.getMemberidcard() + ".jpg");
					this.copyFile(new File("Z:\\exdata\\b.jpg"), idpic);
				}
				startRowNum++;
			}
			wb.write();
			wb.close();
			ZipCompressorByAnt zca = new ZipCompressorByAnt(dirpath + "//"
					+ onno + ".zip");
			zca.compress(dirpath + "//" + onno);

		} catch (IOException | WriteException ex) {
			System.out.println(ex);
		}
	}

	public void copyFile(File sourceFile, File targetFile) throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null) {
				inBuff.close();
			}
			if (outBuff != null) {
				outBuff.close();
			}
		}
	}

	public static void main(String[] args) {
	
	}
}
