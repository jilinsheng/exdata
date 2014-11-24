/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mingda.exdata;

import java.io.File;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

/**
 *
 * @author Administrator
 */
public class ZipCompressorByAnt {  
  
    private File zipFile;  
  
    public ZipCompressorByAnt(String pathName) {  
        zipFile = new File(pathName);  
    }  
      
    public void compress(String srcPathName) {  
        File srcdir = new File(srcPathName);  
        if (!srcdir.exists())  
            throw new RuntimeException(srcPathName + "�����ڣ�");  
          
        Project prj = new Project();  
        Zip zip = new Zip();  
        zip.setProject(prj);  
        zip.setDestFile(zipFile);  
        FileSet fileSet = new FileSet();  
        fileSet.setProject(prj);  
        fileSet.setDir(srcdir);  
        //fileSet.setIncludes("**/*.java"); ������Щ�ļ����ļ��� eg:zip.setIncludes("*.java");  
        //fileSet.setExcludes(...); �ų���Щ�ļ����ļ���  
        zip.addFileset(fileSet);  
          
        zip.execute();  
    }  
}  
