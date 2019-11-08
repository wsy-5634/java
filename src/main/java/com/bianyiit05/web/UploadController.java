package com.bianyiit05.web;


import com.bianyiit05.Service.ServiceImpl;
import com.bianyiit05.domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
@SessionAttributes("/username")  //指定将某个东西存入Session中
public class UploadController {
    @RequestMapping("/method1")
    public String method1(HttpServletRequest request) throws Exception {
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        // 创建解析request的工具类对象
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        //解决request对象
        List<FileItem> fileItems = upload.parseRequest(request);

        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {    ////判断该表单项是否是普通类型
                String fildName = fileItem.getFieldName();
                String fildValue = fileItem.getString();

            } else {      //否则该表单项是file 类型的
                String fileName = fileItem.getName();
                String replace = UUID.randomUUID().toString().replace("-", "");
                fileName = replace + "_" + fileName;
                fileItem.write(new File("D:\\" + fileName));
            }
        }
        return "hello";
    }
@RequestMapping("/method2")
    public String method2(String username, String password,
                          MultipartFile userIcon) throws IOException {
    String filename = userIcon.getOriginalFilename();
    userIcon.transferTo(new File("D:\\upload\\"+ filename));
    return "hello";
    }

    @RequestMapping("/method3")
    public String method3(User user) {
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("/method4")
    public String method4(User user) {
        ServiceImpl service = new ServiceImpl();
        System.out.println("方法执行了");
        service.saveUser();
        return "hello";
    }



}
