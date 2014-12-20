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
import java.util.ArrayList;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
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
	private List<ApplyDTO> l3 = new ArrayList<ApplyDTO>();

	@SuppressWarnings("unused")
	public void GenXLS(String onno, String dirpath, List<ApplyDTO> l1,
			List<ApplyDTO> l2, List<ApplyDTO> fhs) {
		try {
			File dir1 = new File(dirpath + "\\" + onno);
			File dir2 = new File(dirpath + "\\" + onno + "\\SFZ");
			File dir3 = new File(dirpath + "\\" + onno + "\\SQS");

			if (!dir1.exists()) {
				System.out.println(dir1);
				dir1.mkdirs();
				System.out.println(dir2);
				dir2.mkdirs();
				System.out.println(dir2);
				dir3.mkdirs();
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
			WritableSheet ws4 = wb.createSheet("deposit", 3);
			WritableSheet ws5 = wb.createSheet("stock", 4);
			WritableSheet ws6 = wb.createSheet("vehicle", 5);
			WritableSheet ws7 = wb.createSheet("house_property", 6);
			WritableSheet ws8 = wb.createSheet("large_agricultural", 7);

			ReadData rd = new ReadData();
			// List<ApplyDTO> l1 = rd.getData1(uuid);
			// 主申请人姓名 证件类型 证件号码 委托时间
			// 工资性收入 家庭经营净（纯）收入 财产性收入 转移性收入 县级以上民政部门规定应计入家庭收入项目 水田面积（亩） 土地面积（亩）
			// 良种粮食补贴 退耕还林补贴 转租承包土地经营权

			ws1.addCell(new Label(0, startRowNum, "主申请人姓名"));
			ws1.addCell(new Label(1, startRowNum, "证件类型"));
			ws1.addCell(new Label(2, startRowNum, "证件号码"));
			ws1.addCell(new Label(3, startRowNum, "委托时间"));
			ws1.addCell(new Label(4, startRowNum, "工资性收入"));
			ws1.addCell(new Label(5, startRowNum, "家庭经营净（纯）收入"));
			ws1.addCell(new Label(6, startRowNum, "财产性收入"));
			ws1.addCell(new Label(7, startRowNum, "转移性收入"));
			ws1.addCell(new Label(8, startRowNum, "县级以上民政部门规定应计入家庭收入项目"));
			ws1.addCell(new Label(9, startRowNum, "水田面积（亩）"));
			ws1.addCell(new Label(10, startRowNum, "土地面积（亩"));
			ws1.addCell(new Label(11, startRowNum, "良种粮食补贴"));
			ws1.addCell(new Label(12, startRowNum, "退耕还林补贴"));
			ws1.addCell(new Label(13, startRowNum, "转租承包土地经营权"));
			startRowNum++;
			for (ApplyDTO e : l1) {
				ws1.addCell(new Label(0, startRowNum, e.getMastername()));
				ws1.addCell(new Label(1, startRowNum, e.getIdtype()));
				ws1.addCell(new Label(2, startRowNum, e.getMasteridcard()));
				ws1.addCell(new Label(3, startRowNum, e.getWt()));
				ws1.addCell(new Label(4, startRowNum, e.getIncome1()));
				ws1.addCell(new Label(5, startRowNum, e.getIncome2()));
				ws1.addCell(new Label(6, startRowNum, e.getIncome3()));
				ws1.addCell(new Label(7, startRowNum, e.getIncome4()));
				ws1.addCell(new Label(8, startRowNum, e.getIncome5()));
				ws1.addCell(new Label(9, startRowNum, e.getIncome6()));
				ws1.addCell(new Label(10, startRowNum, e.getIncome7()));
				ws1.addCell(new Label(11, startRowNum, e.getIncome8()));
				ws1.addCell(new Label(12, startRowNum, e.getIncome9()));
				ws1.addCell(new Label(13, startRowNum, e.getIncome10()));
				startRowNum++;
			}
			startRowNum = 0;// 起始行
			startColNum = 0;// 起始列
			maxColSize = 4;// 最大列数
			// 主申请人身份证号 姓名 性别 身份证号 与主申请关系
			// 婚姻状况 患病情况 残疾类型 残疾等级 劳动能力 身份类别 就业或上学情况
			ws2.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws2.addCell(new Label(1, startRowNum, "姓名"));
			ws2.addCell(new Label(2, startRowNum, "性别"));
			ws2.addCell(new Label(3, startRowNum, "身份证号"));
			ws2.addCell(new Label(4, startRowNum, "与主申请关系"));
			ws2.addCell(new Label(5, startRowNum, "婚姻状况"));
			ws2.addCell(new Label(6, startRowNum, "患病情况"));
			ws2.addCell(new Label(7, startRowNum, "残疾类型"));
			ws2.addCell(new Label(8, startRowNum, "残疾等级"));
			ws2.addCell(new Label(9, startRowNum, " 劳动能力"));
			ws2.addCell(new Label(10, startRowNum, "身份类别"));
			ws2.addCell(new Label(11, startRowNum, "就业或上学情况"));

			ws3.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws3.addCell(new Label(1, startRowNum, "名称"));
			ws3.addCell(new Label(2, startRowNum, "种类"));
			startRowNum++;
			// List<ApplyDTO> l2 = rd.getData2(uuid);
			for (ApplyDTO e : l2) {
				ws2.addCell(new Label(0, startRowNum, e.getMasteridcard()));
				ws2.addCell(new Label(1, startRowNum, e.getMembername()));
				ws2.addCell(new Label(2, startRowNum, e.getSex()));
				ws2.addCell(new Label(3, startRowNum, e.getMemberidcard()));
				ws2.addCell(new Label(4, startRowNum, e.getRelmaster()));
				ws2.addCell(new Label(5, startRowNum, e.getMarried()));
				ws2.addCell(new Label(6, startRowNum, e.getSicken()));
				ws2.addCell(new Label(7, startRowNum, e.getDeformity()));
				ws2.addCell(new Label(8, startRowNum, e.getDefgrade()));
				ws2.addCell(new Label(9, startRowNum, e.getLabor()));
				ws2.addCell(new Label(10, startRowNum, e.getFmsort()));
				ws2.addCell(new Label(11, startRowNum, e.getJob()));

				File yfile = new File("Z:\\ftproot\\yljz\\exsfz\\"
						+ e.getMemberidcard() + ".jpg");
				if (yfile.exists()) {
					ws3.addCell(new Label(0, startRowNum, e.getMemberidcard()));
					ws3.addCell(new Label(1, startRowNum, e.getMemberidcard()
							+ ".jpg"));
					ws3.addCell(new Label(2, startRowNum, "身份证复印件"));
					File idpic = new File(dirpath + "\\" + onno + "\\SFZ\\"
							+ e.getMemberidcard() + ".jpg");
					this.copyFile(yfile, idpic);
				}

				File yfile1 = new File("Z:\\ftproot\\yljz\\exwts\\"
						+ e.getMemberidcard() + ".jpg");
				if (yfile1.exists()) {
					File idpic = new File(dirpath + "\\" + onno + "\\SQS\\"
							+ e.getMemberidcard() + ".jpg");
					this.copyFile(yfile1, idpic);
				}

				startRowNum++;
			}
			// 主申请人身份证号 姓名 开户行 账户余额
			startRowNum = 0;// 起始行
			startColNum = 0;// 起始列
			maxColSize = 4;// 最大列数
			ws4.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws4.addCell(new Label(1, startRowNum, "姓名"));
			ws4.addCell(new Label(2, startRowNum, "开户行"));
			ws4.addCell(new Label(3, startRowNum, "账户余额"));
			startRowNum++;

			for (ApplyDTO e : l3) {
				ws4.addCell(new Label(0, startRowNum, "主申请人身份证号"));
				ws4.addCell(new Label(1, startRowNum, "姓名"));
				ws4.addCell(new Label(2, startRowNum, "开户行"));
				ws4.addCell(new Label(3, startRowNum, "账户余额"));
				startRowNum++;
			}

			// 主申请人身份证号 股票账户持有人 基金账户持有人 股票（基金）市值
			startRowNum = 0;// 起始行
			startColNum = 0;// 起始列
			maxColSize = 4;// 最大列数
			ws5.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws5.addCell(new Label(1, startRowNum, "股票账户持有人"));
			ws5.addCell(new Label(2, startRowNum, "基金账户持有人"));
			ws5.addCell(new Label(3, startRowNum, "股票（基金）市值"));
			startRowNum++;

			for (ApplyDTO e : l3) {
				ws5.addCell(new Label(0, startRowNum, "主申请人身份证号"));
				ws5.addCell(new Label(1, startRowNum, "股票账户持有人"));
				ws5.addCell(new Label(2, startRowNum, "基金账户持有人"));
				ws5.addCell(new Label(3, startRowNum, "股票（基金）市值"));
				startRowNum++;
			}

			// 主申请人身份证号 车（船）登记证编号 购置时间 车（船）现值
			startRowNum = 0;// 起始行
			startColNum = 0;// 起始列
			maxColSize = 4;// 最大列数
			ws6.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws6.addCell(new Label(1, startRowNum, "车（船）登记证编号"));
			ws6.addCell(new Label(2, startRowNum, "登记证编号"));
			ws6.addCell(new Label(3, startRowNum, "购置时间   车（船）现值"));
			startRowNum++;

			for (ApplyDTO e : l3) {
				ws6.addCell(new Label(0, startRowNum, "主申请人身份证号"));
				ws6.addCell(new Label(1, startRowNum, "车（船）登记证编号"));
				ws6.addCell(new Label(2, startRowNum, "登记证编号"));
				ws6.addCell(new Label(3, startRowNum, "购置时间   车（船）现值"));
				startRowNum++;
			}

			// 主申请人身份证号 有无产权 房产证编号 住房来源 房屋建筑面积
			startRowNum = 0;// 起始行
			startColNum = 0;// 起始列
			maxColSize = 4;// 最大列数
			ws7.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws7.addCell(new Label(1, startRowNum, "有无产权"));
			ws7.addCell(new Label(2, startRowNum, "房产证编号"));
			ws7.addCell(new Label(3, startRowNum, "住房来源"));
			ws7.addCell(new Label(4, startRowNum, "房屋建筑面积"));
			startRowNum++;

			for (ApplyDTO e : fhs) {
				ws7.addCell(new Label(0, startRowNum, e.getMasteridcard()));
				ws7.addCell(new Label(1, startRowNum, e.getChanquan()));
				ws7.addCell(new Label(2, startRowNum, e.getFhnumber()));
				ws7.addCell(new Label(3, startRowNum, e.getLaiyuan()));
				ws7.addCell(new Label(4, startRowNum, e.getFhbuildarea()));
				startRowNum++;
			}

			// 主申请人身份证号 大型农机登记证编号 购置时间 大型农机现值

			startRowNum = 0;// 起始行
			startColNum = 0;// 起始列
			maxColSize = 4;// 最大列数
			ws8.addCell(new Label(0, startRowNum, "主申请人身份证号"));
			ws8.addCell(new Label(1, startRowNum, "大型农机登记证编号"));
			ws8.addCell(new Label(2, startRowNum, "购置时间"));
			ws8.addCell(new Label(3, startRowNum, "大型农机现值"));
			startRowNum++;
			for (ApplyDTO e : l3) {
				ws8.addCell(new Label(0, startRowNum, "主申请人身份证号"));
				ws8.addCell(new Label(1, startRowNum, "大型农机登记证编号"));
				ws8.addCell(new Label(2, startRowNum, "购置时间"));
				ws8.addCell(new Label(3, startRowNum, "大型农机现值"));
				startRowNum++;
			}

			wb.write();
			wb.close();

			ZipFile zipFile = new ZipFile(dirpath + "//" + onno + ".zip");
			String folderToAdd = dirpath + "//" + onno;
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			// 设置密码
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword("a87671500b");
			zipFile.addFile(file, parameters);
			zipFile.addFolder(dir2, parameters);
			zipFile.addFolder(dir3, parameters);

			/*
			 * ZipCompressorByAnt zca = new ZipCompressorByAnt(dirpath + "//" +
			 * onno + ".zip"); zca.compress(dirpath + "//" + onno);
			 */
		} catch (IOException | WriteException | ZipException ex) {
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
